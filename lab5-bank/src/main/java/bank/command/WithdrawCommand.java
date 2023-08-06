package bank.command;

import bank.service.IAccountService;

public class WithdrawCommand implements Command{
    private IAccountService accountService;
    private long accountNo;
    private double amount;

    public WithdrawCommand(IAccountService accountService, long accountNo, double amount) {
        this.accountService = accountService;
        this.accountNo = accountNo;
        this.amount = amount;
    }

    @Override
    public void execute() {
        accountService.withdraw(accountNo, amount);
    }

    @Override
    public void unExecute(Command command) {
        accountService.deposit(((WithdrawCommand) command).accountNo, ((WithdrawCommand)command).amount);
    }
}
