package cn.chandoubatuizi.manage.core.service;

import java.util.Set;

public interface RoleService {

    /**
     * 根据登录名获取用户角色集合
     * 
     * @param loginName
     * @return
     */
    Set<String> getUserRoleSetByLoginName(String loginName);
}
