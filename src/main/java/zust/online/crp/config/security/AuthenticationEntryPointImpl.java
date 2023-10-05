package zust.online.crp.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import zust.online.crp.entity.Result;
import zust.online.crp.entity.enums.ResultCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author qcqcqc
 */
@Component
@Slf4j
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        String message = authException.getMessage();
        if (message.contains("失效")) {
            response.setStatus(402);
        } else {
            response.setStatus(401);
        }
        String msg = "Authentication failed, unable to access system resources";
        response.setContentType("application/json;charset=UTF-8");
        Result<String> error = Result.error(ResultCode.UNAUTHORIZED, msg, message);
        String s = new ObjectMapper().writeValueAsString(error);
        response.getWriter().println(s);
    }

}
