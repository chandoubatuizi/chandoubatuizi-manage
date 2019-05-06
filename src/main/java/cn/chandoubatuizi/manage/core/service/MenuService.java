package cn.chandoubatuizi.manage.core.service;

import java.util.Set;

public interface MenuService {

    /**
     * 根据登录名获取用户权限列表
     * 
     * @param loginName
     * @return
     */
    Set<String> getUserPermsByLoginName(String loginName);
}
