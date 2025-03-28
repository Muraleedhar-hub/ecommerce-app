package com.springboot.aws.dynamodb.entities;

import java.util.Arrays;

public class OrderConfirmationResponse {
    private String order_id;
    private Boolean success;
    private String message;
    private ProductData[] products;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ProductData[] getProducts() {
        return products;
    }

    public void setProducts(ProductData[] products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderConfirmationResponse{" +
                "orderId='" + order_id + '\'' +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}
