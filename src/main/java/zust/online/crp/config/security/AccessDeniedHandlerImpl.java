package zust.online.crp.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
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
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(403);
        response.setContentType("application/json;charset=UTF-8");
        String msg = "Insufficient permissions to access system resources";
        Result<String> error = Result.error(ResultCode.FORBIDDEN, msg, null);
        String s = new ObjectMapper().writeValueAsString(error);
        response.getWriter().println(s);
    }
}
