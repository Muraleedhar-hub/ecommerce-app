package com.springboot.email.freemarker.dto;

import lombok.Data;

@Data
public class ItemList {

    private MailRequest[] items;
    private double totalAmount;

    private String to;
    private String subject;
    private String from;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public MailRequest[] getItems() {
        return items;
    }

    public void setItems(MailRequest[] items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
