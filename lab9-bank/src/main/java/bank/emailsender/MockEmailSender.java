package bank.emailsender;

public class MockEmailSender implements IEmailSender{
    @Override
    public void sendEmail(String reason) {
        System.out.println("Testing: Email sent "+reason);
    }
}
