package aspects;

import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        logger.info("Method: " + methodName + " with params: " + Arrays.asList(arguments) + " will execute");

        Comment comment = new Comment();
        comment.setAuthor("Hacker");
        comment.setText("Hacker bhai hacker \uD83D\uDE0E");

        Object[] newParams = new Object[]{comment};

        Object returnedValue = joinPoint.proceed(newParams);
        logger.info("Executed and returned: " + returnedValue);

        return "FAILED \uD83D\uDD76\uFE0F";
    }
}
