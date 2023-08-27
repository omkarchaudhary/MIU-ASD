package bank.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingProxy implements InvocationHandler {
    private Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //invoke the method on the target
        Object returnValue = method.invoke(target, args);
        Logger.log("Calling method "+ method.getName() + " with argument(s): ");
        for(int p=0; p<args.length;p++){
            Logger.log(" Param[" + p + "]: " + args[p].toString());
        }
        return returnValue;
    }
}
