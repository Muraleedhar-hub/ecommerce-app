package com.springboot.aws.dynamodb.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "CUSTOMER_DETAILS")
public class CustomerDetails implements Serializable {

    @DynamoDBHashKey(attributeName = "CUSTOMER_ID")
    private String customerId;

    @DynamoDBAttribute
    private BillingAddress billingAddress;

    @DynamoDBAttribute
    private ShippingAddress shippingAddress;

    @DynamoDBAttribute
    private boolean isShippingAndBillingAddressSame;

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

    public boolean isShippingAndBillingAddressSame() {
        return isShippingAndBillingAddressSame;
    }

    public void setShippingAndBillingAddressSame(boolean shippingAndBillingAddressSame) {
        isShippingAndBillingAddressSame = shippingAndBillingAddressSame;
    }
}
