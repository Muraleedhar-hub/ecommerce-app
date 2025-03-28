package com.springboot.sms.aws.app.smscontroller;

import com.springboot.sms.aws.app.modal.SmsEntity;
import com.springboot.sms.aws.app.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @GetMapping("/")
    public String checkApp(){
        return "OK";
    }

    @PostMapping("sendSMS")
    public String sendSMS(@RequestBody SmsEntity smsEntity){
        try {
            smsService.sendSms(smsEntity);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "Message has been delivered successfully...";
    }
}
