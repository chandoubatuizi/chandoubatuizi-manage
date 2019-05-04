package cn.chandoubatuizi.manage.core.service.impl;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.chandoubatuizi.manage.common.annotation.Log;
import cn.chandoubatuizi.manage.common.util.IpAddressUtil;
import cn.chandoubatuizi.manage.core.service.LogService;
import cn.chandoubatuizi.manage.dao.LogDOMapper;
import cn.chandoubatuizi.manage.model.LogDO;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDOMapper logDOMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Async("logExecutor")
    public void createLog(ProceedingJoinPoint joinPoint, LogDO logDO) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log logAnnotation = method.getAnnotation(Log.class);

        // Log注解的操作内容
        if (logAnnotation != null) {
            logDO.setOperation(logAnnotation.value());
        }

        // 请求方法的全类名+方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = method.getName();
        logDO.setMethod(className + "." + methodName + "()");
        logDO.setLocation(IpAddressUtil.getAddressByIP(logDO.getIp()));

        logDOMapper.insertSelective(logDO);
    }

}
