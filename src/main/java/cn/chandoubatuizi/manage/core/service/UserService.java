package cn.chandoubatuizi.manage.core.service;

import cn.chandoubatuizi.manage.model.UserDO;

public interface UserService {

    /**
     * 根据登录名查询用户信息
     * 
     * @param loginName
     * @return
     */
    UserDO getUserByLoginName(String loginName);

    /**
     * 校验用户身份并有尝试次数限制
     * 
     * @param user
     * @param password
     */
    void validateUser(UserDO user, String password);

    /**
     * 更新用户登录信息
     * 
     * @param loginName
     */
    void updateLoginInfo(String loginName);

}
