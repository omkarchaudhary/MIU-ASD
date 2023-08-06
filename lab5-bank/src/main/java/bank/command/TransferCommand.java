package bank.command;

import bank.service.IAccountService;

public class TransferCommand implements Command{
    private IAccountService accountService;
    private long fromAccountNo;
    private long toAccountNo;
    private double amount;
    private String description;

    public TransferCommand(IAccountService accountService, long fromAccountNo, long toAccountNo, double amount, String description){
        this.accountService = accountService;
        this.fromAccountNo = fromAccountNo;
        this.toAccountNo = toAccountNo;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public void execute() {
        accountService.transferFunds(fromAccountNo, toAccountNo, amount, description);
    }

    @Override
    public void unExecute(Command command) {
        accountService.withdraw(((TransferCommand)command).toAccountNo ,((TransferCommand) command).amount);
    }
}
