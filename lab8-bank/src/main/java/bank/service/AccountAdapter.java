package bank.service;

import bank.adapter.AccountDTO;
import bank.domain.Account;

public class AccountAdapter {

    public static AccountDTO AccountToAccountDTO(Account account){
        return new AccountDTO(account.getAccountnumber(), account.getEntryList(), account.getCustomer());
    }

    public static Account AccountDTOToAccount(AccountDTO accountDTO){
        return new Account(accountDTO.getAccountnumber(), accountDTO.getEntryList(), accountDTO.getCustomer());
    }
}
