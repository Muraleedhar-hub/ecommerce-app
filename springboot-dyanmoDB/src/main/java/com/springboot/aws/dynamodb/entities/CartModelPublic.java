package com.springboot.aws.dynamodb.entities;

public class CartModelPublic {

    private String customerId;
    private Integer userId;
    private ProductData[] products;
    private ShippingAddress shippingAddress;
    private BillingAddress billingAddress;
    private boolean isShippingAndBillingAddressSame;

    public boolean isShippingAndBillingAddressSame() {
        return isShippingAndBillingAddressSame;
    }

    public void setShippingAndBillingAddressSame(boolean shippingAndBillingAddressSame) {
        isShippingAndBillingAddressSame = shippingAndBillingAddressSame;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ProductData[] getProducts() {
        return products;
    }

    public void setProducts(ProductData[] products) {
        this.products = products;
    }
}

