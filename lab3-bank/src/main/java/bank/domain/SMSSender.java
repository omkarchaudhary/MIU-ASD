package bank.domain;

import bank.service.Observer;

public class SMSSender implements Observer {
    public static void sendSMS(Account account){
        System.out.println("The SMS is sent "+account.getCustomer());
    }
    @Override
    public void update(Account account) {
        sendSMS(account);
    }
}
