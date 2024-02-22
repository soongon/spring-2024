package kr.re.kitri.hello.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* kr.re.kitri.hello.service.*Service.*(..))")
    public void loggingBeforeService(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        log.info(className + "." + methodName + " 함수가 호출되었습니다.");
    }

    @Around("execution(* kr.re.kitri.hello.service.*.*(..))")
    public Object measureRunningTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        log.info(joinPoint.getSignature().getName() + " 메소드의 실행시간은 " + elapsedTime + "ms 입니다.");

        return obj;
    }
}
