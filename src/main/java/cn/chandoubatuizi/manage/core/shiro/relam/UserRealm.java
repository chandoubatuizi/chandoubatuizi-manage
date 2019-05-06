package cn.chandoubatuizi.manage.core.shiro.relam;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import cn.chandoubatuizi.manage.common.constant.ManageConstant;
import cn.chandoubatuizi.manage.core.service.MenuService;
import cn.chandoubatuizi.manage.core.service.RoleService;
import cn.chandoubatuizi.manage.core.service.UserService;
import cn.chandoubatuizi.manage.model.UserDO;

/**
 * 自定义Realm 实现登录认证和授权
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    /**
     * 权限授予
     * 
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserDO user = (UserDO) SecurityUtils.getSubject().getPrincipal();

        // 获取用户角色和权限信息
        Set<String> userRoleSet = roleService.getUserRoleSetByLoginName(user.getLoginName());
        Set<String> userPermsSet = menuService.getUserPermsByLoginName(user.getLoginName());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(userRoleSet);
        simpleAuthorizationInfo.setStringPermissions(userPermsSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     * 
     * @param token
     *            身份认证token
     * @return
     * @throws AuthenticationException
     *             认证相关异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 根据token获取账号密码
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String userName = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());

        // 根据登录名查询用户信息
        UserDO user = userService.getUserByLoginName(userName);

        if (user == null) {
            throw new UnknownAccountException("账号或密码错误");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码错误");
        }
        if (ManageConstant.UserAccount.USER_LOCK == user.getStatus()) {
            throw new LockedAccountException("该账号被锁定，请联系系统管理员处理");
        }

        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
