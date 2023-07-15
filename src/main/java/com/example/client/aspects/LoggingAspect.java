package com.example.client.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.client.services.*Service.*(..))")
    public void logMethodInvocation(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("Executing method: " + methodName);
    }

    // Additional advice methods (e.g., @After, @Around)
    // ...
}
