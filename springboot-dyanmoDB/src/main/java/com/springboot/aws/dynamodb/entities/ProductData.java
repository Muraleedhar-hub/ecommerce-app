package com.springboot.aws.dynamodb.entities;

public class ProductData {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIncart() {
        return incart;
    }

    public void setIncart(Integer incart) {
        this.incart = incart;
    }

    private Integer id;
    private Integer incart;

}


