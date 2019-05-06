package cn.chandoubatuizi.manage.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chandoubatuizi.manage.core.service.UserService;
import cn.chandoubatuizi.manage.dao.UserDOMapper;
import cn.chandoubatuizi.manage.model.UserDO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public UserDO getUserByLoginName(String loginName) {
        return userDOMapper.getUserByLoginName(loginName);
    }
}
