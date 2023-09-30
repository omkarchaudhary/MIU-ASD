package customers.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class CalculateAdvice {
    @Around("execution(* *.CustomerDAO.*(..) )")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
// print the time to the console
        System.out.println("The method name: "+call.getSignature().getName()+" and the total time: "+totaltime);

        return retVal;

    }
}
