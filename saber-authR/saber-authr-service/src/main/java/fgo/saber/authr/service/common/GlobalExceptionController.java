package fgo.saber.authr.service.common;

import fgo.saber.base.exception.CommonBaseException;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.exception.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @author zq
 * @Date 2018/9/12
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionController {

    @ExceptionHandler(ConstraintViolationException.class)
    public JsonResult constraintViolationException(HttpServletRequest request, ConstraintViolationException exception) {
        String url = request.getRequestURL().toString();
        log.warn("exception url: {}, message: {}", url, exception);
        return AuthResultStatus.PARAM_EXCEPTION;
    }

    @ExceptionHandler(ParamException.class)
    public JsonResult paramException(HttpServletRequest request, ParamException exception) {
        String url = request.getRequestURL().toString();
        log.warn("exception url: {}, message: {}", url, exception.getMessage());
        return JsonResult.fail(AuthResultStatus.PARAM_EXCEPTION.getCode(), exception.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public JsonResult bindException(HttpServletRequest request, BindException exception) {
        String url = request.getRequestURL().toString();
        log.warn("exception url: {}, message: {}", url, exception);
        String errorMsg = exception.getBindingResult().getFieldError().getField()
                + "类型错误";
        return JsonResult.fail(AuthResultStatus.PARAM_TYPE_EXCEPTION.getCode(), errorMsg);
    }

    @ExceptionHandler(CommonBaseException.class)
    public JsonResult commonsException(HttpServletRequest request, CommonBaseException exception) {
        String url = request.getRequestURL().toString();
        log.warn("exception url: {}, message: {}", url, exception);
        if (exception.getResult() == null) {
            return AuthResultStatus.ERROR;
        }
        return exception.getResult();
    }

    @ExceptionHandler(Exception.class)
    public JsonResult exception(HttpServletRequest request, Exception exception) {
        String url = request.getRequestURL().toString();
        log.warn("exception url: {}, message: {}", url, exception);
        return AuthResultStatus.ERROR;
    }

}
