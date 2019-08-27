package fgo.saber.authr.service.common;

import fgo.saber.base.json.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zq
 * @date 2019/8/27
 */
@RestController
@Slf4j
public class NotFoundExceptionController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = {"/error"})
    public JsonResult notFound(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        log.warn("404-url: {}", url);
        return AuthResultStatus.NOT_FOUND_EXCEPTION;
    }

}
