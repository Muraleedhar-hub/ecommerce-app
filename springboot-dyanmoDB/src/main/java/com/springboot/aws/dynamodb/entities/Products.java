package com.springboot.aws.dynamodb.entities;

public class Products {

    private ProductData[] prodData;

    public ProductData[] getProdData() {
        return prodData;
    }

    public void setProdData(ProductData[] prodData) {
        this.prodData = prodData;
    }
}
