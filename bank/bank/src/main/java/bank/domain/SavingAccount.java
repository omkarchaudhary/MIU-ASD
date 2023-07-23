package bank.domain;

import java.util.Date;

public class SavingAccount extends  Account{


    public SavingAccount(long accountnr, AccountType accountType) {
        super(accountnr, accountType);
    }

    @Override
    public void addInterest() {
        AccountEntry entry = new AccountEntry(new Date(), 0, "Interest amount", String.valueOf(accountnumber), customer.getName());
        entry.setDescription("Interest amount");
        if(getBalance() < 1000)
            entry.setAmount(getBalance()*0.01);
        else if(getBalance() > 1000 && getBalance() < 5000 )
            entry.setAmount(getBalance()*0.02 );
        else
            entry.setAmount(getBalance()*0.05);

        this.entryList.add(entry);
    }
}
