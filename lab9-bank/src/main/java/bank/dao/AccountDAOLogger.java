package bank.dao;

public abstract class AccountDAOLogger {
    public void log(String logMessage){
        System.out.println("The logged message is "+logMessage);
    }
}
