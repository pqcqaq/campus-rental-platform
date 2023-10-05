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
import zust.online.crp.entity.po.User;
import zust.online.crp.entity.vo.UserInfoRecordsVo;
import zust.online.crp.entity.vo.UserVo;
import zust.online.crp.mapper.UserMapper;
import zust.online.crp.service.CollectInfoService;
import zust.online.crp.service.LikeRecordsService;
import zust.online.crp.service.PostService;
import zust.online.crp.service.UserService;
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
        User byId = this.getById(id);
        // 刷新redis
        redisTemplate.delete(userVo.getToken());
        String token = jwtUtils.createToken(byId);
        UserLogin userLogin1 = new UserLogin(byId);
        redisTemplate.opsForValue().set(token, userLogin1, 7, TimeUnit.DAYS);
        return byId.toVo(token);
    }

    @Override
    public String saveAlterAvatar(String avatar) {
        // 从上下文中取出用户信息
        SecurityContext context = SecurityContextHolder.getContext();
        User userLogin = (User) context.getAuthentication().getPrincipal();
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
        token = jwtUtils.createToken(userLogin);
        UserLogin userLogin1 = new UserLogin(userLogin);
        redisTemplate.opsForValue().set(token, userLogin1, 7, TimeUnit.DAYS);
        if (userLogin != null) {
            return userLogin.toVo(token);
        }
        throw new RuntimeException("刷新失败");
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
}
