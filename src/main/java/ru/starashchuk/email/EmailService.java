package ru.starashchuk.email;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import ru.starashchuk.email.dto.ReceiptEmailDTO;

import java.util.Properties;

public class EmailService {
    private EmailConfig emailConfig;

    public EmailService(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    public void sendReceipt(ReceiptEmailDTO receipt) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", emailConfig.getHost());
        properties.put("mail.smtp.port", emailConfig.getPort());
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailConfig.getUsername(), emailConfig.getPassword());
            }
        });
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailConfig.getUsername()));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(receipt.getToEmail()));
        message.setSubject("Чек о покупке #" + receipt.getReceiptId());
        message.setContent(ReceiptTemplate.build(receipt), "text/html; charset=utf-8");
        Transport.send(message);

    }

}
