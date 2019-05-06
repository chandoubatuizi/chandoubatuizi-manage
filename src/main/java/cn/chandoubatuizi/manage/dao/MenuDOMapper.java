package cn.chandoubatuizi.manage.dao;

import java.util.List;

import cn.chandoubatuizi.manage.model.MenuDO;

public interface MenuDOMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MenuDO record);

    int insertSelective(MenuDO record);

    MenuDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuDO record);

    int updateByPrimaryKey(MenuDO record);

    List<MenuDO> getMenuDOListByLoginName(String loginName);
}