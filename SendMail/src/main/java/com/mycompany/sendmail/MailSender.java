package com.mycompany.sendmail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

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
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", 465);
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", 465);

            Authenticator auth = new SMTPAuthenticator("maipham6996@gmail.com", "mothaibabon");
            Session session = Session.getInstance(props, auth);
            session.setDebug(true);
            MimeMessage msg = new MimeMessage(session);
            msg.setText("dddddddddddd", "UTF-8");
            msg.setSubject("ssssssssssss", "UTF-8");
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress("mai.pham.intern@ntq-solution.com.vn"));
            Transport.send(msg);
        } catch (MessagingException e) {
            
        }
    }
}
