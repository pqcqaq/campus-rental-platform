package zust.online.crp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanzoy.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.UserLogin;
import zust.online.crp.entity.dto.LoginParam;
import zust.online.crp.entity.po.User;
import zust.online.crp.mapper.UserMapper;
import zust.online.crp.service.UserService;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author qcqcqc
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Resource
    private RedisTemplate<String, UserLogin> redisTemplate;

    @Override
    public Result<String> login(LoginParam loginParam) {
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
        redisTemplate.opsForValue().set(token, user,30, TimeUnit.DAYS);
        //返回
        return Result.success("登录成功", token);
    }
}
