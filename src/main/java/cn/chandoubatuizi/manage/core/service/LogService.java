package cn.chandoubatuizi.manage.core.service;

import org.aspectj.lang.ProceedingJoinPoint;

import cn.chandoubatuizi.manage.model.LogDO;

public interface LogService {

    /**
     * 异步保存用户操作日志
     * 
     * @param joinPoint
     * @param logDO
     */
    void createLog(ProceedingJoinPoint joinPoint, LogDO logDO);
}
