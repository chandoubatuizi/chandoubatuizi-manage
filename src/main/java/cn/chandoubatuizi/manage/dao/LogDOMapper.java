package cn.chandoubatuizi.manage.dao;

import cn.chandoubatuizi.manage.model.LogDO;

public interface LogDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(LogDO record);

    int insertSelective(LogDO record);

    LogDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogDO record);

    int updateByPrimaryKey(LogDO record);
}