package com.xiafei.newsbackend.aspect;

import com.xiafei.newsbackend.exception.ServiceException;
import com.xiafei.newsbackend.util.Constant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by qujie on 2018/12/10
 * service异常切面拦截
 */
@Aspect
@Component
public class ServiceExceptionAop {
    Logger logger = LoggerFactory.getLogger(RuntimeException.class);

    @Autowired
    private Environment environment;

    @Pointcut("execution(* com.xiafei.newsbackend.service.*.*(..))")
    public void log(){
    }
    @AfterThrowing(value = "log()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint ,Throwable e){
        if (!(e instanceof ServiceException)){
             /**
             * 日志打印出错方法+原因
             */
            if(environment.getActiveProfiles().equals("dev")){
                e.printStackTrace();
            }else{
                String logStr = "出错类：%s%n出错方法%s";
                logger.error(String.format(logStr,joinPoint.getTarget().getClass().getName(),joinPoint.getSignature().getName()),e);
             }
             /**
              *
              * 抛出系统异常
              */
             throw new RuntimeException(Constant.SYSTEM_ERROR);

         }
    }
}
