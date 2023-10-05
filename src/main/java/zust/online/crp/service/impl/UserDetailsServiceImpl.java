package zust.online.crp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zust.online.crp.entity.UserLogin;
import zust.online.crp.entity.po.User;
import zust.online.crp.mapper.UserMapper;

import java.util.Objects;

/**
 * @author qcqcqc
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username).last("limit 1");
        User user = userMapper.selectOne(queryWrapper);
        //异常
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户名未发现");
        }
        //数据封装为UserDetails返回
        return new UserLogin(user);

    }
}
