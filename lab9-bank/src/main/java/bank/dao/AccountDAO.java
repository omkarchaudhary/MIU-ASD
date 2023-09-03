package bank.dao;

import java.util.*;
import bank.domain.Account;

public class AccountDAO extends AccountDAOLogger implements IAccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();

	public void saveAccount(Account account) {
		accountlist.add(account); // add the new
		log("Account created");
	}

	public void updateAccount(Account account) {
		Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			accountlist.remove(accountexist); // remove the old
			accountlist.add(account); // add the new
			log("Account updated");
		}

	}

	public Account loadAccount(long accountnumber) {
		for (Account account : accountlist) {
			if (account.getAccountnumber() == accountnumber) {
				log("Load an account");
				return account;
			}
		}
		return null;
	}

	public Collection<Account> getAccounts() {
		log("Get list of account");
		return accountlist;
	}

}
