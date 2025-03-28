package com.ecom.jwt.api.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.ecom.jwt.api.entity.AuthRequest;
import com.ecom.jwt.api.entity.Register;
import com.ecom.jwt.api.entity.User;
import com.ecom.jwt.api.entity.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    @Autowired
    private DynamoDBMapper mapper;

    public UserResponse getLoginDetails(AuthRequest authRequest, UserResponse response){
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":username", new AttributeValue().withS(authRequest.getUsername()));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userName = :username").withExpressionAttributeValues(eav);
        List<Register> usersList = mapper.scan(Register.class, scanExpression);
        for (Register register: usersList){
            response.setUsername(register.getUserName());
            response.setLastName(register.getLastName());
            response.setFirstName(register.getFirstName());
            response.setId(register.getUserId());
        }

        return response;
    }

    public User findByUserName(String userName){
        User user = new User();
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":userName", new AttributeValue().withS(userName));
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("userName = :userName").withExpressionAttributeValues(eav);
        List<Register> usersList = mapper.scan(Register.class, scanExpression);
        for (Register register : usersList){
            user.setUserName(register.getUserName());
            user.setPassword(register.getPassword());
        }
        return user;
    }

}
