package bank.factory;

import bank.dao.IAccountDAO;
import bank.emailsender.IEmailSender;

public interface MyFactory {
    IAccountDAO getAccountDAO();
    IEmailSender getEmailSenderDAO();
}
