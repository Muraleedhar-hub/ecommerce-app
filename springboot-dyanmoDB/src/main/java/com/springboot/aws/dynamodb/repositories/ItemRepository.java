package com.springboot.aws.dynamodb.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.springboot.aws.dynamodb.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    @Autowired(required=true)
    private DynamoDBMapper mapper;

    public ProductModelServer addItem(ProductModelServer item) {
        mapper.save(item);
        return item;
    }

    public ServerResponse findAllItems() {
        List<ProductModelServer> productModelServerList = new ArrayList<>();
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setCount(2);
        productModelServerList = mapper.scan(ProductModelServer.class, new DynamoDBScanExpression());
        final int listSize = productModelServerList.size();
        serverResponse.setProducts(productModelServerList.stream().toArray(n ->new ProductModelServer[listSize]));
        return serverResponse;
    }

    public ProductModelServer findItemById(Integer id) {
        return mapper.load(ProductModelServer.class, id);
    }

    public String deleteItem(ProductModelServer productModelServer) {
        mapper.delete(productModelServer);
        return "Item removed !!";
    }

    public String editItem(ProductModelServer productModelServer) {
        mapper.save(productModelServer, buildExpression(productModelServer));
        return "record updated ...";
    }

    private DynamoDBSaveExpression buildExpression(ProductModelServer productModelServer) {
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
        expectedMap.put("ID", new ExpectedAttributeValue(new AttributeValue().withS(String.valueOf(productModelServer.getId()))));
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }

    public String placeOrder(CartModelPublic cartModelPublic){
        String orderId = generateOrderId();
        PlaceOrder p = new PlaceOrder();

        for (int i = 0; i < cartModelPublic.getProducts().length; i++) {
            ProductModelServer pms = mapper.load(ProductModelServer.class, cartModelPublic.getProducts()[i].getId());
            p.setId(generateOrderId());
            p.setItemId(String.valueOf(cartModelPublic.getProducts()[i].getId()));
            p.setOrderId(orderId);
            p.setPrice(pms.getPrice());
            p.setQuantity(String.valueOf(cartModelPublic.getProducts()[i].getIncart()));
            mapper.save(p);
        }
        return orderId;
    }

    public ProductResponseModel[] findOrderItemById(String orderId) {
        int i = 0;
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":orderId", new AttributeValue().withS(orderId));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("orderId = :orderId").withExpressionAttributeValues(eav);
        List<PlaceOrder> orderItemsList = mapper.scan(PlaceOrder.class, scanExpression);
        ProductResponseModel[] productResponseModelArr = new ProductResponseModel[orderItemsList.size()];

        for (PlaceOrder placeOrder : orderItemsList) {
            ProductModelServer item = mapper.load(ProductModelServer.class, Integer.valueOf(placeOrder.getItemId()));
            ProductResponseModel productResponseModel = new ProductResponseModel();
            productResponseModel.setId(Integer.valueOf(placeOrder.getItemId()));
            productResponseModel.setDescription(item.getDescription());
            productResponseModel.setPrice(placeOrder.getPrice());
            productResponseModel.setQuantityOrdered(Integer.valueOf(placeOrder.getQuantity()));
            productResponseModel.setTitle(item.getCategory());
            productResponseModel.setImage(item.getImage());
            productResponseModelArr[i] = productResponseModel;
            i++;
        }
        return productResponseModelArr;
    }

    public CustomerDetails addCustomerDetails(CustomerDetails customerDetails) {
        mapper.save(customerDetails);
        return customerDetails;
    }

    public Register registerUser(Register register) {
        mapper.save(register);
        return register;
    }

    private String generateOrderId(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String formatDateTime = now.format(format);
        return formatDateTime;
    }
}