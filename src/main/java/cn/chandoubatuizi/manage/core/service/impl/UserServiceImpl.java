package cn.chandoubatuizi.manage.core.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.chandoubatuizi.manage.common.constant.ManageConstant;
import cn.chandoubatuizi.manage.common.util.ShiroUtil;
import cn.chandoubatuizi.manage.core.service.UserService;
import cn.chandoubatuizi.manage.dao.UserDOMapper;
import cn.chandoubatuizi.manage.model.UserDO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Resource(name = "loginTimeLimitCacheManager")
    private CacheManager cacheManager;

    /**
     * redis缓存
     */
    private Cache<String, AtomicInteger> loginTimesLimitCache;

    /**
     * 初始化redisCache，不存在自动创建
     */
    @PostConstruct
    public void init() {
        loginTimesLimitCache = cacheManager.getCache("loginTimesLimitCache");
    }

    @Override
    public UserDO getUserByLoginName(String loginName) {
        return userDOMapper.getUserByLoginName(loginName);
    }

    @Override
    public void validateUser(UserDO user, String password) {
        String loginName = user.getLoginName();
        AtomicInteger retryCount = loginTimesLimitCache.get(loginName);

        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            loginTimesLimitCache.put(loginName, retryCount);
        }
        if (retryCount.incrementAndGet() > ManageConstant.MAX_RETRY_COUNT) {
            throw new ExcessiveAttemptsException("超过最大尝试次数，请稍后登录");
        }
        if (!ShiroUtil.encrypt(password, user.getSalt()).equals(user.getPassword())) {
            loginTimesLimitCache.put(loginName, retryCount);
            throw new IncorrectCredentialsException("账号或密码错误");
        } else {
            loginTimesLimitCache.remove(loginName);
        }

    }

    @Override
    public void updateLoginInfo(String loginName) {
        userDOMapper.updateLoginInfo(loginName, ShiroUtil.getIp());
    }
}
