package com.xiafei.newsbackend.aspect;

import com.xiafei.newsbackend.util.Constant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * dao异常切面拦截
 * */
@Aspect
@Component
public class DaoExceptionAop {
    Logger logger = LoggerFactory.getLogger(DaoExceptionAop.class);

    @Pointcut("execution(* com.xiafei.newsbackend.dao.*.*(..))")
    public void log() {
    }

    @AfterThrowing(value = "log()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        //日志打印出错方法+原因
        logger.error("出错方法：" + joinPoint.getSignature().getName() + "---错误原因:" + e.getMessage());
        //抛出异常
        throw new RuntimeException(Constant.SYSTEM_ERROR);
    }
}
