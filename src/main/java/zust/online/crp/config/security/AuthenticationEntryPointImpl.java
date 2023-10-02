package zust.online.crp.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.enums.ResultCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qcqcqc
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(200);
        String msg = "认证失败，无法访问系统资源";
        response.setContentType("application/json;charset=UTF-8");
        Result<String> error = Result.error(ResultCode.UNAUTHORIZED, msg, null);
        String s = new ObjectMapper().writeValueAsString(error);
        response.getWriter().println(s);
    }
}
