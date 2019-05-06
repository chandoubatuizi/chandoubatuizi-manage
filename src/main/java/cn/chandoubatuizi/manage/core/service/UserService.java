package cn.chandoubatuizi.manage.core.service;

import cn.chandoubatuizi.manage.model.UserDO;

public interface UserService {

    UserDO getUserByLoginName(String loginName);

}
