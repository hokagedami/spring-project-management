package com.codekage.pma.logging;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.codekage.pma.controllers..*)"
            + "|| within(com.codekage.pma.dao..*)")
    public void definePackagePointCut() {

    }


    /*@Before("definePackagePointCut()")
    public void logBefore(JoinPoint joinPoint) {
        log.debug("\n \n \n");
        log.debug("----------Before Method Execution---------------");
        log.debug("\n");
        log.debug("{}.{} with argument(s):: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
    }

    @After("definePackagePointCut()")
    public void logAfter() {
        log.debug("----------After Method Execution---------------");
    }*/

    @Around("definePackagePointCut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) {
        log.debug("\n \n \n");
        log.debug("----------Before Method Execution---------------");
        log.debug("\n");
        log.debug("{}.{} with argument(s):: {}",
                proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                proceedingJoinPoint.getSignature().getName(),
                Arrays.toString(proceedingJoinPoint.getArgs()));

        Object proceedResult = null;
        try {
            proceedResult = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        log.debug("----------After Method Execution---------------");
        return proceedResult;
    }
}
