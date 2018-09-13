package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.UserDto;
import fgo.saber.base.json.JsonResult;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @Date 2018/9/13
 */
public interface UserCloudService {


    JsonResult<UserDto> findUserWithId(@NotNull @RequestParam(name = "userId") Long userId);

    JsonResult<Boolean> saveUser(@NotNull @RequestParam(name = "userId") UserDto userDto);

}
