package org.example.hm8.aspect;


import org.example.hm8.model.Timesheet;
import org.example.hm8.service.TimesheetService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.DZEight.Service.TimesheetService.*(..))")
    public void timesheetServiceMethodsPointcut() {
        log.info("TimesheetService pointcut");
    }

    @Before("execution(* com.example.DZEight.Service.TimesheetService.findById(Long))")
    public void beforeTimesheetServiceFindById(JoinPoint joinPoint) {
        logArguments(joinPoint);
    }

    @Before("timesheetServiceMethodsPointcut()")
    public void before(JoinPoint joinPoint) {
        logArguments(joinPoint);
    }

    @After(value = "timesheetServiceMethodsPointcut()")
    public void after(JoinPoint joinPoint) {
        logArguments(joinPoint);
        log.info("After method: {} ", joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "timesheetServiceMethodsPointcut()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        logArguments(joinPoint);
        log.info("AfterThrowing method: {} , Exception : {}", joinPoint.getSignature().getName(),
                exception.getClass().getName());
    }

    @AfterReturning(value = "timesheetServiceMethodsPointcut()")
    public void afterReturning(JoinPoint joinPoint) {
        logArguments(joinPoint);
        log.info("AfterReturning method: {} ", joinPoint.getSignature().getName());
    }

    private void logArguments(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder(methodName).append("(");
        for (int i = 0; i < args.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(args[i].getClass().getSimpleName()).append(" = ").append(args[i]);
        }
        sb.append(")");
        log.info(sb.toString());
    }
}
