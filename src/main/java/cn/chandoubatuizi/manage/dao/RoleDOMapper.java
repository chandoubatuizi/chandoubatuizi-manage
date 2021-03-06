package cn.chandoubatuizi.manage.dao;

import cn.chandoubatuizi.manage.model.RoleDO;

import java.util.List;

public interface RoleDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(RoleDO record);

    int insertSelective(RoleDO record);

    RoleDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleDO record);

    int updateByPrimaryKey(RoleDO record);

    List<RoleDO> getRoleDOListByLoginName(String loginName);
}