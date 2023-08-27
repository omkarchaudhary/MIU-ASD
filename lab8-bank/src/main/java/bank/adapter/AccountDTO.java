package bank.adapter;

import bank.domain.AccountEntry;
import bank.domain.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDTO {
    private long accountnumber;
    private Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
    private Customer customer;

    public AccountDTO(long accountnumber, Collection<AccountEntry> entryList, Customer customer) {
        this.accountnumber = accountnumber;
        this.entryList = entryList;
        this.customer = customer;
    }

    public AccountDTO(long accountnumber, Customer customer){
        this.accountnumber = accountnumber;
        this.customer = customer;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Collection<AccountEntry> getEntryList() {
        return entryList;
    }

    public void setEntryList(Collection<AccountEntry> entryList) {
        this.entryList = entryList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        double balance=0;
        for (AccountEntry entry : entryList) {
            balance+=entry.getAmount();
        }
        return balance;
    }
}
