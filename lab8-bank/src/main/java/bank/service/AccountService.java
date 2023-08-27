package bank.service;

import java.lang.reflect.Proxy;
import java.util.Collection;

import bank.adapter.AccountDTO;
import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.proxy.LoggingProxy;
import bank.proxy.StopWatchProxy;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private IAccountDAO loggerProxy;
	private IAccountDAO stopWatchProxy;

	public AccountService(){
		accountDAO=new AccountDAO();
		ClassLoader classLoader = IAccountDAO.class.getClassLoader();
		loggerProxy = (IAccountDAO) Proxy.newProxyInstance(classLoader, new Class[]{IAccountDAO.class},new LoggingProxy(accountDAO));
		stopWatchProxy = (IAccountDAO) Proxy.newProxyInstance(classLoader, new Class[]{IAccountDAO.class},new StopWatchProxy(accountDAO));
	}

	public AccountDTO createAccount(long accountNumber, String customerName) {
		AccountDTO accountDTO = new AccountDTO(accountNumber, new Customer(customerName));
		Customer customer = new Customer(customerName);
		accountDTO.setCustomer(customer);
		accountDAO.saveAccount(AccountAdapter.AccountDTOToAccount(accountDTO));
		loggerProxy.saveAccount(AccountAdapter.AccountDTOToAccount(accountDTO));
		stopWatchProxy.saveAccount(AccountAdapter.AccountDTOToAccount(accountDTO));
		return accountDTO;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		loggerProxy.saveAccount(account);
		stopWatchProxy.saveAccount(account);
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		loggerProxy.saveAccount(account);
		stopWatchProxy.saveAccount(account);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		loggerProxy.saveAccount(account);
		stopWatchProxy.saveAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}
}
