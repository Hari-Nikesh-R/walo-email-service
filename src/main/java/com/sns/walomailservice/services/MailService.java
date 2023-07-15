package com.sns.walomailservice.services;

import com.sns.walomailservice.dtos.MailBody;
import org.springframework.stereotype.Service;

@Service
public interface MailService {
    Boolean sendEmail(MailBody mailBody);
}
