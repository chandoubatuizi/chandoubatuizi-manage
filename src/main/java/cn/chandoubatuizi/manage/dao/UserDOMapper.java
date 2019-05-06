package cn.chandoubatuizi.manage.dao;

import cn.chandoubatuizi.manage.model.UserDO;

public interface UserDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserDO record);

    UserDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDO record);

    UserDO getUserByLoginName(String loginName);
}