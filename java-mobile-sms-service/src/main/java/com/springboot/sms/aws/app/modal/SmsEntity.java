package com.springboot.sms.aws.app.modal;

import lombok.Data;

@Data
public class SmsEntity {

    private String message;
    private String number;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
