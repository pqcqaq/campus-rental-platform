package zust.online.crp.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import zust.online.crp.entity.Result;

/**
 * @author qcqcqc
 */
@RestControllerAdvice
@Order(999)
public class BaseExceptionHandler {
    /**
     * Exception
     * // 放在异常处理的最后，防止被其他异常处理器拦截
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public Result<String> exceptionHandler(Exception e) {
        return Result.error(400, "服务器内部错误！", e.getMessage());
    }
}
