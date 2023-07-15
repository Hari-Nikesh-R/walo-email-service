package com.sns.walomailservice.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class MailServiceProperties {
    @Value("${twilio.user}")
    private String twilioAuthSid;

    @Value("${twilio.auth}")
    private String twilioAuth;
}
