package aspects;

import model.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.ForkJoinTask;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("@annotation(annotations.ToLog)")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method with name: " + joinPoint.getSignature().getName() + " and params:"
                + Arrays.asList(joinPoint.getArgs())+ " about to be executed");
    }

    @AfterReturning(value = "@annotation(annotations.ToLog)", returning = "result")
    public void logAfter(Object result) {
        logger.info("Method returned: " + result);
    }

    /**
     * Similar annotations: @After and @AfterThrowing exists
     */
}
