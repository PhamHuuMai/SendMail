/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.ntqsolution.worker.email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Rua
 */
@Component
public class EmailDeliver {

    protected static final Logger LOGGER = LoggerFactory.getLogger(EmailDeliver.class);

    private class SMTPAuthenticator extends javax.mail.Authenticator {

        private String email;
        private String password;

        public SMTPAuthenticator(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(email, password);
        }
    }

    public void deliver() {
        try {
            Properties props = new Properties();
//            props.put("mail.smtp.user", email.getSmtpUser());
//            props.put("mail.smtp.host", email.getSmtpHost());
//            props.put("mail.smtp.port", email.getSmtpPort());
//            props.put("mail.transport.protocol", "smtp");
//            props.put("mail.smtp.starttls.enable", "true");
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.debug", "true");
            String smtpHost = "smtp.gmail.com";
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.socketFactory.port", 465);
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", 465);

            Authenticator auth = new SMTPAuthenticator("maipham6996@gmail.com","mothaibabon");
            Session session = Session.getInstance(props, auth);
            session.setDebug(true);
            MimeMessage msg = new MimeMessage(session);
            msg.setText("ssss", "UTF-8");
            msg.setSubject("ccccc", "UTF-8");
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("huumaipham1996@gmail.com"));
            Transport.send(msg);
        } catch (MessagingException e) {
            LOGGER.error("Deliver email exception", e);
        }
    }
}
