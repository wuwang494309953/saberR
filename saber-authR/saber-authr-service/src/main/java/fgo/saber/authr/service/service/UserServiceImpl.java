package fgo.saber.authr.service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.common.AuthResultStatus;
import fgo.saber.authr.service.dao.UserMapper;
import fgo.saber.authr.service.model.entity.User;
import fgo.saber.authr.service.model.param.PageParam;
import fgo.saber.authr.service.model.param.UserParam;
import fgo.saber.authr.service.model.vo.UserVO;
import fgo.saber.common.abst.AbstBaseService;
import fgo.saber.util.BeanUtil;
import fgo.saber.util.SbPreconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

/**
 * @author zq
 * @date 2019/8/28
 */
@Service
public class UserServiceImpl extends AbstBaseService<User> {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Mapper<User> getDao() {
        return userMapper;
    }

    public PageInfo<UserVO> findUserList(UserParam userParam, PageParam pageParam) {
        String orderStr = pageParam.sortStr();
        if (StringUtils.isAnyBlank(pageParam.getSortKey(), pageParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "create_time desc";
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderStr);

        return new PageInfo<>(userMapper.getUserNav(userParam));
    }

    public void save(UserParam userParam) {
        if (userParam.getUserId() == null) {
            User user = new User();
            BeanUtil.overWrite(userParam, user);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            userMapper.insertSelective(user);
        } else {
            User user = userMapper.selectByPrimaryKey(userParam.getUserId());
            SbPreconditions.checkNotNull(user, AuthResultStatus.USER_NOT_EXIST);
            BeanUtil.overWrite(userParam, user);
            user.setUpdateTime(new Date());
            userMapper.updateByPrimaryKeySelective(user);
        }

    }

    public User getWithUserName(String username) {
        User query = User.builder().username(username).status(1).build();
        return userMapper.selectOne(query);
    }


}
