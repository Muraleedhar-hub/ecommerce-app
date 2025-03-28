package com.springboot.aws.dynamodb.controller;

import com.springboot.aws.dynamodb.entities.*;
import com.springboot.aws.dynamodb.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class SpringbootDynamoDBController {

    @Autowired
    public ItemRepository repository;

    @GetMapping("/")
    public String appStatus(){
        return "OK";
    }

    @PostMapping("/saveItem")
    public ProductModelServer saveItem(@RequestBody ProductModelServer productModelServer) {
        return repository.addItem(productModelServer);
    }

    @PostMapping("/orders/new")
    public OrderConfirmationResponse placeOrder(@RequestBody CartModelPublic cartModelPublic) throws InterruptedException {
        OrderConfirmationResponse response = new OrderConfirmationResponse();
        response.setMessage("Order Placed");
        response.setSuccess(true);
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerId(cartModelPublic.getCustomerId());
        customerDetails.setShippingAddress(cartModelPublic.getShippingAddress());
        if(!cartModelPublic.isShippingAndBillingAddressSame()){
            customerDetails.setBillingAddress(cartModelPublic.getBillingAddress());
        }
        repository.addCustomerDetails(customerDetails);
        response.setOrder_id(repository.placeOrder(cartModelPublic));
        //this.sendMail();
        return response;
    }

    @GetMapping("/getItems")
    public ServerResponse findAllItems(@PathParam("limit") String limit) {
        return repository.findAllItems();
    }

    @GetMapping("/getItem/{id}")
    public ProductModelServer findItem(@PathVariable Integer id) {
        return repository.findItemById(id);
    }

    @DeleteMapping("/deleteItem")
    public String deleteItem(@RequestBody ProductModelServer productModelServer) {
        return repository.deleteItem(productModelServer);
    }

    @PutMapping("/editItem")
    public String updateItem(@RequestBody ProductModelServer productModelServer) {
        return repository.editItem(productModelServer);
    }

    @GetMapping("/orders/{orderId}")
    public ProductResponseModel[] findByOrderItems(@PathVariable String orderId) {
        return repository.findOrderItemById(orderId);
    }
}
