package bank.command;

import bank.service.IAccountService;

public class DepositCommand implements Command{
    private IAccountService accountService;
    private long accountNo;
    private double amount;

    public DepositCommand(IAccountService accountService, long accountNo, double amount){
        this.accountService = accountService;
        this.accountNo = accountNo;
        this.amount = amount;
    }

    @Override
    public void execute() {
        accountService.deposit(accountNo, amount);
    }

    @Override
    public void unExecute(Command command) {
        accountService.withdraw(((DepositCommand) command).accountNo, ((DepositCommand)command).amount);
    }
}
