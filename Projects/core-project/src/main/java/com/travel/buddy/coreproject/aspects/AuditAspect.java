package com.travel.buddy.coreproject.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {/*
    private static Logger logger = LoggerFactory.getLogger(AuditAspect.class);

    @Pointcut("execution(* com.travel.buddy.coreproject.services.*.*.*.*(..))")
    public void serviceMethods(){
        //
    }


    @Before("serviceMethods()")
    public void beforeMethod() {
        logger.info("before executing the method");
    }

    @Around("serviceMethods()")
    public Object aroundMethod(ProceedingJoinPoint joinpoint) {
        try {
            long start = System.nanoTime();
            Object result = joinpoint.proceed();
            long end = System.nanoTime();
            logger.info(String.format("%s took %d ns", joinpoint.getSignature(), (end - start)));
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @After("serviceMethods()")
    public void afterMethod() {
        logger.info("after executing method");
    }
*/
}
