package cn.chandoubatuizi.manage.dao;

import cn.chandoubatuizi.manage.model.UserDO;
import org.apache.ibatis.annotations.Param;

public interface UserDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserDO record);

    UserDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserDO record);

    UserDO getUserByLoginName(String loginName);

    void updateLoginInfo(@Param("loginName") String loginName, @Param("ip") String ip);
}