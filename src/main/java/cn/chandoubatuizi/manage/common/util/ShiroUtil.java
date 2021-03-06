package cn.chandoubatuizi.manage.common.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;

public class ShiroUtil {

    /**
     * shiro MD5加盐加密
     * 
     * @param password
     * @param salt
     * @return
     */
    public static String encrypt(String password, String salt) {
        return new Md5Hash(password, salt).toHex();
    }

    /**
     * 获取用户IP地址
     * 
     * @return
     */
    public static String getIp() {
        return SecurityUtils.getSubject().getSession().getHost();
    }
}
