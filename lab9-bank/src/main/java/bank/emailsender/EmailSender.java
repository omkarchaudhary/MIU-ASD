package bank.emailsender;

public class EmailSender implements IEmailSender {
    //Lazy
    private static EmailSender emailSender;
    private EmailSender(){
        //Prevent from the reflection api
        if(emailSender != null){
            throw new RuntimeException("Use getEmailSender method to get the single instance of this class.");
        }
    }

    public static EmailSender getEmailSender(){
        //double check pattern
        if(emailSender == null){
            synchronized (EmailSender.class){
                if(emailSender == null){
                    emailSender = new EmailSender();
                }
            }
        }
        return emailSender;
    }
    @Override
    public void sendEmail(String reason) {
        System.out.println("Production: Email sent "+reason);
    }
}
