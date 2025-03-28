package com.springboot.aws.dynamodb.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.springboot.aws.dynamodb.entities.PlaceOrder;

import java.util.List;

@EnableScan
public interface OrderRepository extends CrudRepository<PlaceOrder, String>{
    List<PlaceOrder> findByOrderId(String orderId);
}
