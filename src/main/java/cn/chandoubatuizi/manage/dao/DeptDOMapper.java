package cn.chandoubatuizi.manage.dao;

import cn.chandoubatuizi.manage.model.DeptDO;

public interface DeptDOMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(DeptDO record);


    int insertSelective(DeptDO record);


    DeptDO selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(DeptDO record);


    int updateByPrimaryKey(DeptDO record);
}