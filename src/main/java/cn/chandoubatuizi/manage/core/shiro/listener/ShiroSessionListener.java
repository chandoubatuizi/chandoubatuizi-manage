package cn.chandoubatuizi.manage.core.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * shiro session的定制化实现，可以根据具体业务编写业务逻辑
 */
public class ShiroSessionListener implements SessionListener {
    @Override
    public void onStart(Session session) {
        System.out.println("====shiro session start====");

    }

    @Override
    public void onStop(Session session) {
        System.out.println("====shiro session stop====");
    }

    @Override
    public void onExpiration(Session session) {
        System.out.println("====shiro session expired====");
    }
}
