package bank.domain;

import java.util.Date;

public class CheckingAccount extends Account{
    public CheckingAccount(long accountnr, AccountType accountType) {
        super(accountnr, accountType);
    }

    @Override
    public void addInterest() {
        AccountEntry entry = new AccountEntry(new Date(), 0, "Interest amount", String.valueOf(accountnumber), customer.getName());
        entry.setDescription("Interest amount");
        if(getBalance() < 1000)
            entry.setAmount(getBalance()*0.015);
        else
            entry.setAmount(getBalance()*0.025);
        this.entryList.add(entry);
    }
}
