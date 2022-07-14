package com.example.demo.component;


import cn.hutool.core.io.FileUtil;
import cn.hutool.system.UserInfo;
import com.example.demo.generator.domain.OperateLog;
import com.example.demo.generator.service.OperateLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 接口切面日志记录
 * */
@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class WebLogAspect {


    final OperateLogService operateLogService;

    @Pointcut("execution(public * com.example.demo.controller.BookController.*(..))")
    public void WebLogCollect(){}


    @Around("WebLogCollect()")
    public Object doGet(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("------开始执行------");
        LocalDateTime start = LocalDateTime.now();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //通过切点获得结果以及方法
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        //获得请求结果
        Method method = signature.getMethod();
        log.info(request.getLocale().getDisplayName());
        log.info(request.getLocalName());
        OperateLog aspectLog = OperateLog.builder().operateIp(request.getRemoteAddr()).createtimestamp(start).operateUrl(request.getRequestURI())
                .operateTime(start).operateUser(request.getRemoteUser()).operateMethod(method.getName()).updatetimestamp(start)
                .build();
        /**
         * 添加日志信息
         * */
        operateLogService.addOperateLog(aspectLog);

        log.info("------执行结束------");
        LocalDateTime end = LocalDateTime.now();
        log.info("执行时间为---{}毫秒", Duration.between(start,end).toMillis());
        return proceedingJoinPoint.proceed();
    }
}
