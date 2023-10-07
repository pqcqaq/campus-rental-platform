package zust.online.crp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanzoy.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.UserLogin;
import zust.online.crp.entity.dto.LoginParam;
import zust.online.crp.entity.po.CollectInfo;
import zust.online.crp.entity.po.Post;
import zust.online.crp.entity.po.SubscribeRecord;
import zust.online.crp.entity.po.User;
import zust.online.crp.entity.vo.UserInfoRecordsVo;
import zust.online.crp.entity.vo.UserVo;
import zust.online.crp.exception.ErrorAlterStatusException;
import zust.online.crp.mapper.UserMapper;
import zust.online.crp.service.*;
import zust.online.crp.utils.ContextUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author qcqcqc
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private JWTUtils jwtUtils;
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private RedisTemplate<String, UserLogin> redisTemplate;
    @Resource
    private CollectInfoService collectInfoService;
    @Resource
    private LikeRecordsService likeRecordsService;
    @Resource
    @Lazy
    private PostService postService;
    @Resource
    private SubscribeRecordService subscribeRecordService;

    @Override
    public Result<UserVo> login(LoginParam loginParam) {
        //进行用户认证。获取AuthenticationManager authenticate
        //获取认证对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginParam.getUsername(), loginParam.getPassword());
        //认证
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //认证失败
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        //认证成功，生成token
        //获取用户信息（getPrincipal()）
        UserLogin user = (UserLogin) authenticate.getPrincipal();
        String token = jwtUtils.createToken(user);
        // 存入redis
        redisTemplate.opsForValue().set(token, user, 7, TimeUnit.DAYS);
        //返回
        UserVo vo = user.toVo(token);
        return Result.success("登录成功", vo);
    }

    @Override
    public UserVo alter(UserVo userVo) {
        User user = userVo.toPo();
        // 从上下文中取出用户信息
        SecurityContext context = SecurityContextHolder.getContext();
        User userLogin = (User) context.getAuthentication().getPrincipal();
        Long id = userLogin.getId();
        user.setId(id);
        this.updateById(user);
        //更新user
        UserVo byId = this.getById(id, true);
        // 刷新redis
        redisTemplate.delete(userVo.getToken());
        UserLogin userLogin1 = new UserLogin(byId.toPo());
        String token = jwtUtils.createToken(userLogin1);
        redisTemplate.opsForValue().set(token, userLogin1, 7, TimeUnit.DAYS);
        return byId;
    }

    @Override
    public String saveAlterAvatar(String avatar) {
        // 从上下文中取出用户信息
        User userLogin = ContextUtil.getCurrentUser();
        if (userLogin == null) {
            throw new RuntimeException("修改失败");
        }
        avatar = avatar.substring(1, avatar.length() - 1);
        userLogin.setAvatar(avatar);
        this.updateById(userLogin);
        return "success";
    }

    @Override
    public UserVo refreshToken(HttpServletRequest request) {
        // 取出token
        String token = request.getHeader("token");
        if (Objects.equals(token, "null") || token == null) {
            throw new RuntimeException("刷新失败");
        }
        // 从redis中删除
        redisTemplate.delete(token);
        User userLogin = ContextUtil.getCurrentUser();
        if (userLogin == null) {
            throw new RuntimeException("刷新失败");
        }
        Long id = userLogin.getId();
        UserVo byId = this.getById(id, true);
        // 用来存入redis的对象需要重新获取否则会出现序列化异常（role为空）
        User byId1 = this.getById(id);
        UserLogin userLogin1 = new UserLogin(byId1);
        token = jwtUtils.createToken(userLogin1);
        byId.setToken(token);
        redisTemplate.opsForValue().set(token, userLogin1, 7, TimeUnit.DAYS);
        return byId;
    }

    @Override
    public Boolean logout(HttpServletRequest request) {
        // 取出token
        String token = request.getHeader("token");
        if (Objects.equals(token, "null") || token == null) {
            throw new RuntimeException("退出失败");
        }
        // 从redis中删除
        Boolean delete = redisTemplate.delete(token);
        return !Boolean.FALSE.equals(delete);
    }

    @Override
    public List<UserInfoRecordsVo> getUserInfoRecords() {
        User currentUser = ContextUtil.getCurrentUser();

        UserInfoRecordsVo lease = new UserInfoRecordsVo();
        lease.setName("我的租赁");
        lease.setRouterName("lease");
        lease.setValue(0L);

        UserInfoRecordsVo hire = new UserInfoRecordsVo();
        hire.setName("我的出租");
        hire.setRouterName("hire");
        hire.setValue(0L);

        UserInfoRecordsVo collect = new UserInfoRecordsVo();
        collect.setName("我的收藏");
        collect.setRouterName("collect");
        collect.setValue(0L);

        UserInfoRecordsVo publish = new UserInfoRecordsVo();
        publish.setName("我的发布");
        publish.setRouterName("publish");
        publish.setValue(0L);

        ArrayList<UserInfoRecordsVo> userInfoRecordsVos = new ArrayList<>();
        userInfoRecordsVos.add(lease);
        userInfoRecordsVos.add(hire);
        userInfoRecordsVos.add(collect);
        userInfoRecordsVos.add(publish);

        if (currentUser == null) {
            return userInfoRecordsVos;
        }

        List<CollectInfo> list = collectInfoService.list(new LambdaQueryWrapper<CollectInfo>().eq(CollectInfo::getCreateBy, currentUser.getId()));
        ArrayList<CollectInfo> collectInfos = new ArrayList<>();
        for (CollectInfo collectInfo : list) {
            boolean b = postService.checkIsDelete(collectInfo.getPostId());
            if (!b) {
                collectInfos.add(collectInfo);
            }
        }
        collect.setValue((long) collectInfos.size());

        long count1 = postService.count(new LambdaQueryWrapper<Post>().eq(Post::getCreateBy, currentUser.getId()));
        publish.setValue(count1);

        return userInfoRecordsVos;
    }

    @Override
    public String saveBackground(String background) {
        // 从上下文中取出用户信息
        User userLogin = ContextUtil.getCurrentUser();
        if (userLogin == null) {
            throw new RuntimeException("修改失败");
        }
        background = background.substring(1, background.length() - 1);
        userLogin.setBackground(background);
        this.updateById(userLogin);
        return "success";
    }

    /**
     * 获取用户信息
     *
     * @param userId   用户id
     * @param detailed 是否详细
     * @return 用户信息Vo
     */
    @Override
    public UserVo getById(Long userId, boolean detailed) {
        User currentUser = ContextUtil.getCurrentUser();

        // 查询当前用户是否关注了该用户
        boolean isSubscribe = false;
        if (currentUser != null) {
            SubscribeRecord one = subscribeRecordService.getOne(new LambdaQueryWrapper<SubscribeRecord>()
                    .eq(SubscribeRecord::getCreateBy, currentUser.getId())
                    .eq(SubscribeRecord::getPublisherId, userId));
            if (one != null) {
                isSubscribe = true;
            }
        }

        User user = this.getById(userId);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!detailed) {
            return user.toVo(null, null, null, isSubscribe);
        }
        // 获取关注的数量
        long sub = subscribeRecordService.count(new LambdaQueryWrapper<SubscribeRecord>()
                .eq(SubscribeRecord::getCreateBy, userId));
        // 获取用户被关注的数量
        long pub = subscribeRecordService.count(new LambdaQueryWrapper<SubscribeRecord>()
                .eq(SubscribeRecord::getPublisherId, userId));
        return user.toVo(null, sub, pub, isSubscribe);
    }

    @Override
    public boolean follow(Long userId) {
        User currentUser = ContextUtil.getCurrentUser();
        if (currentUser == null) {
            throw new RuntimeException("用户不存在");
        }
        // 查询当前用户是否关注了该用户
        SubscribeRecord one = subscribeRecordService.getOne(new LambdaQueryWrapper<SubscribeRecord>()
                .eq(SubscribeRecord::getCreateBy, currentUser.getId())
                .eq(SubscribeRecord::getPublisherId, userId));
        if (one != null) {
            // 取消关注
            boolean b = subscribeRecordService.removeById(one.getId());
            if (!b) {
                throw new ErrorAlterStatusException("取消关注失败");
            }
            // 返回取消关注
            return false;
        } else {
            // 关注
            SubscribeRecord subscribeRecord = new SubscribeRecord();
            subscribeRecord.setCreateBy(currentUser.getId());
            subscribeRecord.setPublisherId(userId);
            boolean save = subscribeRecordService.save(subscribeRecord);
            if (!save) {
                throw new ErrorAlterStatusException("关注失败");
            }
            return true;
        }
    }

    @Override
    public List<UserVo> getFansList(Long userId) {
        List<SubscribeRecord> list = subscribeRecordService.list(new LambdaQueryWrapper<SubscribeRecord>()
                .eq(SubscribeRecord::getPublisherId, userId)
                .orderByDesc(SubscribeRecord::getCreateTime)
        );
        ArrayList<UserVo> userVos = new ArrayList<>();
        for (SubscribeRecord subscribeRecord : list) {
            UserVo byId = this.getById(subscribeRecord.getCreateBy(), false);
            userVos.add(byId);
        }
        return userVos;
    }
}
