package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    /*
     * execution: When the method is called
     * Intercepted method may have any return type(first "*")
     * Intercepted method must be in the 'services' package
     * Intercepted method can be in any class (second "*")
     * Intercepted method can have any name (third "*")
     * Intercepted method can have any parameters("(..)")
     */
    @Around("execution(* services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Yet to execute");
        joinPoint.proceed();
        logger.info("Executed");
    }
}
