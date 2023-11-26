package com.example.homework.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReservationAspect {

    private static final Logger logger = LoggerFactory.getLogger(ReservationAspect.class);

    @Around("execution(* com.example.homework.services.ReservationService.addReservation(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - startTime;
        logger.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");

        return proceed;
    }
}
