package com.sns.walomailservice.services.impl;


import com.sns.walomailservice.dtos.MailBody;
import com.sns.walomailservice.services.MailService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static com.sns.walomailservice.utils.Constants.ERROR_CAUSED_INFO;


@Service
public class MailServiceImpl implements MailService {

    @Override
    public Boolean sendEmail(MailBody mailBody) {
        try {
            final String username = "dosmartie@gmail.com";
            final String password = "k9DGrv5ghC7SOncR";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "mail.smtp2go.com");
            props.put("mail.smtp.port", "2525");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailBody.getRecipient()));
            message.setSubject("Walo verification code");
            message.setText(mailBody.getMsgBody());
            Transport.send(message);
            return true;
        }
        catch (Exception exception){
            System.out.println(ERROR_CAUSED_INFO+exception.getMessage());
            return false;
        }
    }
}
