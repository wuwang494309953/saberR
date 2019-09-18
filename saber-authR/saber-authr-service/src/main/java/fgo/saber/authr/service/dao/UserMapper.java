package fgo.saber.authr.service.dao;

import fgo.saber.authr.service.model.entity.User;
import fgo.saber.authr.service.model.param.UserParam;
import fgo.saber.authr.service.model.vo.UserVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    List<UserVO> getUserNav(UserParam param);

}