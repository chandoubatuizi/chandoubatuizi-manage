package cn.chandoubatuizi.manage.dao;

import cn.chandoubatuizi.manage.model.RoleDO;

public interface RoleDOMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(RoleDO record);


    int insertSelective(RoleDO record);


    RoleDO selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(RoleDO record);


    int updateByPrimaryKey(RoleDO record);
}