package com.sns.walomailservice.controller;


import com.sns.walomailservice.dtos.BaseResponse;
import com.sns.walomailservice.dtos.MailBody;
import com.sns.walomailservice.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.sns.walomailservice.utils.Constants.*;

@RestController
@RequestMapping(value = "/notify")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping(value = SEND_MAIL)
    public BaseResponse<?> sendEmail(@RequestBody MailBody mailBody){
        try{
            if(mailService.sendEmail(mailBody)){
                return new BaseResponse<>(MAIL_SUCCESS, HttpStatus.OK.value(), "", true, mailBody);
            }
            else{
                return new BaseResponse<>(MAIL_UNKNOWN_ERROR, HttpStatus.NO_CONTENT.value(), MAIL_UNSUCCESSFUL,false, null);
            }
        }
        catch (Exception exception){
            return new BaseResponse<>(MAIL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getLocalizedMessage(), false, null);
        }
    }
}
