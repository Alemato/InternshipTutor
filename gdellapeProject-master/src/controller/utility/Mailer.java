package controller.utility;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer {
    public static void send(String to, String subject, String msg) {

        final String user = "Internshiptutor";//change accordingly
        final String pass = "A123456789ingweb@";
        final String mail = "internshiptutor@matteifamily.net";
        Properties props = new Properties();
        props.put("mail.smtp.host", "10.0.0.0");//change accordingly
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pass);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(msg, "text/html");
            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
