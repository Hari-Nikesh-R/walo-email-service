package com.sns.walomailservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MailBody {
    private String recipient;
    private String msgBody;
    private String subject;
    private Map<String,String> code;
}
