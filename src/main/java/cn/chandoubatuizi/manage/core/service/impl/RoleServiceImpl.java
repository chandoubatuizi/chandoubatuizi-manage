package cn.chandoubatuizi.manage.core.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chandoubatuizi.manage.core.service.RoleService;
import cn.chandoubatuizi.manage.dao.RoleDOMapper;
import cn.chandoubatuizi.manage.model.RoleDO;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDOMapper roleDOMapper;

    @Override
    public Set<String> getUserRoleSetByLoginName(String loginName) {
        List<RoleDO> roleList = roleDOMapper.getRoleDOListByLoginName(loginName);
        return roleList.stream().map(RoleDO::getRoleName).collect(Collectors.toSet());
    }
}
