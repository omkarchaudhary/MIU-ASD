package bank.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StopWatchProxy implements InvocationHandler {
    private Object target;

    public StopWatchProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StopWatch.start();
        Object returnValue = method.invoke(target,args);
        StopWatch.stop();
        System.out.println("The stopwatch proxy method " + method.getName() + " took " + StopWatch.getTimeElapse() + " ms");
        return returnValue;
    }
}
