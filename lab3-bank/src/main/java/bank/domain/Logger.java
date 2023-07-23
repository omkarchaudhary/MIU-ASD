package bank.domain;

import bank.service.Observer;

public class Logger implements Observer {
    public void log(Account account){
        System.out.println("The Logger message is logged "+ account.getCustomer());
    }

    @Override
    public void update(Account account) {
        log(account);
    }
}
