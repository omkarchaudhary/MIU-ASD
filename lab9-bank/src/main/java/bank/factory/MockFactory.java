package bank.factory;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.dao.MockAccountDAO;
import bank.emailsender.EmailSender;
import bank.emailsender.IEmailSender;
import bank.emailsender.MockEmailSender;

public class MockFactory implements MyFactory{
    @Override
    public IAccountDAO getAccountDAO() {
        return new MockAccountDAO();
    }

    @Override
    public IEmailSender getEmailSenderDAO() {
        return new MockEmailSender();
    }
}
