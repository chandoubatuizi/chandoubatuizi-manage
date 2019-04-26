package cn.chandoubatuizi.manage.core.service.impl;

import cn.chandoubatuizi.manage.core.service.UserService;
import cn.chandoubatuizi.manage.dao.UserDOMapper;
import cn.chandoubatuizi.manage.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDOMapper userDOMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create() {
        UserDO userDO = new UserDO();
        userDO.setPassword("1111");
        userDO.setSalt("112121");
        int affectedRows = userDOMapper.insertSelective(userDO);
        int a = 1 / 0;
        return affectedRows;
    }

    @Override
    public UserDO select() {
        return userDOMapper.selectByPrimaryKey(1);
    }
}
