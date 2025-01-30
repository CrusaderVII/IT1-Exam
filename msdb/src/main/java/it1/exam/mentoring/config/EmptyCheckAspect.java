package it1.exam.mentoring.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Aspect
@Component
@Slf4j
public class EmptyCheckAspect {

    @Around("@annotation(emptyCheck)")
    public Object checkCollection(ProceedingJoinPoint joinPoint, EmptyCheck emptyCheck) throws Throwable {
        Object[] args = joinPoint.getArgs();

        if (args.length > 0 && args[0] instanceof Collection<?> collection) {
            if (collection.isEmpty()) {
                log.info("Empty collection, processing skipped");
                return Collections.emptyList();
            } else {
                log.info("Processing collection...");
                return joinPoint.proceed();
            }
        }

        return joinPoint.proceed();
    }
}
