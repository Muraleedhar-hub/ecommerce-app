package com.springboot.aws.dynamodb.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "ORDER")
public class PlaceOrder implements Serializable{
    @DynamoDBHashKey(attributeName = "ID")
    private String id;
    @DynamoDBAttribute
    private String itemId;
    @DynamoDBAttribute
    private String orderId;
    @DynamoDBAttribute
    private String userId;
    @DynamoDBAttribute
    private String quantity;
    @DynamoDBAttribute
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PlaceOrder{" +
                "id=" + id +
                ", itemId='" + itemId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price=" + price +
                '}';
    }
}
