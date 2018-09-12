package fgo.saber.auth.provider.common;

import fgo.saber.auth.api.exception.AuthErrorResult;
import fgo.saber.base.json.JsonResult;
import lombok.extern.slf4j.Slf4j;
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
        log.warn("exception url: {}, message: {}", url, exception.getMessage());

        return AuthErrorResult.PARAM_EXCEPTION;
    }

}
