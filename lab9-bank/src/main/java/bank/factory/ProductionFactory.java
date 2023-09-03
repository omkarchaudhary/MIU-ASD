package bank.factory;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.emailsender.EmailSender;
import bank.emailsender.IEmailSender;

public class ProductionFactory implements MyFactory{
    @Override
    public IAccountDAO getAccountDAO() {
        return new AccountDAO();
    }

    @Override
    public IEmailSender getEmailSenderDAO() {
        return EmailSender.getEmailSender();
    }
}
