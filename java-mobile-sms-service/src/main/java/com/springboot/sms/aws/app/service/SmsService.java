package com.springboot.sms.aws.app.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.springboot.sms.aws.app.modal.SmsEntity;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    private static final String apiKey = "apikey=" + "HdHSiRTWKVU-s9J5kNsvS143RLOanFzopIVyVQHNAw";
    private static final String sender = "&sender=" + "TXTLCL";

    public String sendSms(SmsEntity smsEntity) throws Exception{
            String message = "&message=" + smsEntity.getMessage();
            String numbers = "&numbers=" + smsEntity.getNumber();
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return stringBuffer.toString();

    }
}
