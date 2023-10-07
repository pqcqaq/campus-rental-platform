package zust.online.crp.handler;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import zust.online.crp.entity.Result;
import zust.online.crp.exception.ErrorAlterStatusException;
import zust.online.crp.exception.ErrorFoundUserException;

import java.util.List;

/**
 * 指定异常处理
 *
 * @author qcqcqc
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * MethodArgumentNotValidException
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<String> paramExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult exceptions = e.getBindingResult();
        String msg = null;
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                msg = fieldError.getDefaultMessage();
            }
        }
        return Result.error(400, "参数错误", msg);
    }

    /**
     * ErrorFoundUserException
     *
     * @param e 异常
     * @return 结果
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ErrorFoundUserException.class})
    public Result<String> errorFoundUserExceptionHandler(ErrorFoundUserException e) {
        return Result.error(400, "用户未登录", e.getMessage());
    }

    /**
     * FileSizeLimitExceededException
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({FileSizeLimitExceededException.class})
    public Result<String> fileSizeLimitExceededExceptionHandler(FileSizeLimitExceededException e) {
        return Result.error(400, "文件大小超过限制", e.getMessage());
    }

    /**
     * ErrorAlterStatusException
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ErrorAlterStatusException.class})
    public Result<String> errorAlterStatusExceptionHandler(ErrorAlterStatusException e) {
        return Result.error(400, "修改失败", e.getMessage());
    }

    /**
     * MethodArgumentTypeMismatchException
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public Result<String> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e) {
        return Result.error(400, "参数类型错误", e.getMessage());
    }

}
