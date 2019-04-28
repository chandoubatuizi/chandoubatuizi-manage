package cn.chandoubatuizi.manage.dao;

import cn.chandoubatuizi.manage.model.UserRoleDO;

public interface UserRoleDOMapper {

    int insert(UserRoleDO record);

    int insertSelective(UserRoleDO record);
}