package com.sns.walomailservice.services.impl;


import com.sns.walomailservice.dtos.MailBody;
import com.sns.walomailservice.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static com.sns.walomailservice.utils.Constants.ERROR_CAUSED_INFO;
import static com.sns.walomailservice.utils.Constants.SEND_MAIL_INFO;


@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;
    @Override
    public Boolean sendEmail(MailBody mailBody) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject(mailBody.getSubject());
            simpleMailMessage.setText(mailBody.getMessage());
            simpleMailMessage.setTo(mailBody.getRecipientEmail());
            if (Objects.nonNull(mailBody.getCc())) {
                simpleMailMessage.setCc(mailBody.getCc());
            }
            if (Objects.nonNull(mailBody.getBcc())) {
                simpleMailMessage.setBcc(mailBody.getBcc());
            }
            System.out.println(SEND_MAIL_INFO + simpleMailMessage);
            mailSender.send(simpleMailMessage);
            return true;
        }
        catch (Exception exception){
            System.out.println(ERROR_CAUSED_INFO+exception.getMessage());
            return false;
        }
    }
}
