package cn.chandoubatuizi.manage.core.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chandoubatuizi.manage.core.service.MenuService;
import cn.chandoubatuizi.manage.dao.MenuDOMapper;
import cn.chandoubatuizi.manage.model.MenuDO;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDOMapper menuDOMapper;

    @Override
    public Set<String> getUserPermsByLoginName(String loginName) {
        List<MenuDO> menuList = menuDOMapper.getMenuDOListByLoginName(loginName);
        return menuList.stream().map(MenuDO::getPerms).collect(Collectors.toSet());
    }
}
