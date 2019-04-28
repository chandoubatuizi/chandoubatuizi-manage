package cn.chandoubatuizi.manage.common.aspect;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.chandoubatuizi.manage.common.util.HttpContextUtil;
import cn.chandoubatuizi.manage.core.service.LogService;
import cn.chandoubatuizi.manage.model.LogDO;

@Component
@Aspect
public class LogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(cn.chandoubatuizi.manage.common.annotation.Log)")
    public void pointCut() {
        // do nothing
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        // 执行方法
        result = joinPoint.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        System.out.println("================aroundTest============" + time + "======");

        // 根据subject取出用户名和IP
        // Subject subject = SecurityUtils.getSubject();
        // String ip = subject.getSession().getHost();
        // UserDO userDO = (UserDO) subject.getPrincipal();
        String requestURI = HttpContextUtil.getRequestURI();
        Map<String, String[]> parameterMap = HttpContextUtil.getParameterMap();

        String params = JSON.toJSONString(parameterMap);
        System.out.println(params);

        LogDO logDO = new LogDO();
        // logDO.setLoginName(userDO.getLoginName());
        // logDO.setIp(ip);
        logDO.setUrl(requestURI);
        logDO.setTime((int) time);
        logDO.setParams(params);
        // 异步执行
        logService.createLog(joinPoint, logDO);
        return result;
    }
}
