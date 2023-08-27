package bank.proxy;

public class StopWatch {
    private static long startTime = 0;
    private static long endTime = 0;
    public static void start(){
        startTime =  System.currentTimeMillis();
    }
    public static void stop(){
        endTime =  System.currentTimeMillis();
    }
    public static long getTimeElapse(){
        return endTime - startTime;
    }
}
