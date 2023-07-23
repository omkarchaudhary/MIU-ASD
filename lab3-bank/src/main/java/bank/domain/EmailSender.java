package bank.domain;

import bank.service.Observer;

public class EmailSender implements Observer {
    public static void sendEmail(Account account){
        System.out.println("The email is sent "+account.getCustomer());
    }
    @Override
    public void update(Account account) {
        sendEmail(account);
    }
}
