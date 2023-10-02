package zust.online.crp.config.security;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.UserLogin;
import zust.online.crp.entity.enums.ResultCode;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Andy
 * @date 2023-8-1 001 10:16
 * <p>
 * 这个过滤器的主要功能：如果token有效，把用户信息存入Security上下文中
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Resource
    private RedisTemplate<String, UserLogin> redisTemplate;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 从请求头中获取token
        String token = request.getHeader("token");
        // 如果token为空，则放行
        if (Objects.equals(token, "null") || StringUtils.isBlank(token)) {
            filterChain.doFilter(request, response);
            // 不再执行下面的代码
            return;
        }
        // 去redis中查询token是否存在 如果不存在，则抛出异常

        // 如果存在，则获取用户信息
        UserLogin loginUserBo = redisTemplate.opsForValue().get(token);
//        // 如果用户信息为空，则放行（暂时觉得这个判断没啥用）
//        if (Objects.isNull(user)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
        if (Objects.isNull(loginUserBo)) {
            Result<String> error = Result.error(ResultCode.UNAUTHORIZED, "Token has expired, please log in again", null);
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(error);
            response.getOutputStream().write(s.getBytes());
            return;
        }

        // 存入Security上下文中
        // 把权限信息也存入(第三个参数)
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserBo.getUser(), null, loginUserBo.getAuthorities());
        // 存入上下文中
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 放行
        filterChain.doFilter(request, response);

    }
}
