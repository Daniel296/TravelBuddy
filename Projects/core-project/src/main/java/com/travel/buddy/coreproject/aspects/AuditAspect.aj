package com.travel.buddy.coreproject.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AuditAspect {
    private static Logger logger = LoggerFactory.getLogger(AuditAspect.class);

    @Pointcut(value = "execution(* com.travel.buddy.coreproject.services.*.*.*(..))")
    public void serviceMethods(){
        //
    }


    @Before("serviceMethods()")
    public void beforeMethod() {
        System.out.println("before method");
        //logger.info("before method");
    }

    @Around("serviceMethods()")
    public Object aroundMethod(ProceedingJoinPoint joinpoint) {
        try {
            long start = System.nanoTime();
            Object result = joinpoint.proceed();
            long end = System.nanoTime();
            System.out.println(String.format("%s took %d ns", joinpoint.getSignature(), (end - start)));
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @After("serviceMethods()")
    public void afterMethod() {
        System.out.println("after method");
    }

}
