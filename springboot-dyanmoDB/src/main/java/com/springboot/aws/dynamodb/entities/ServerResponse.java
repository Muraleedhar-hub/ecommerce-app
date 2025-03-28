package com.springboot.aws.dynamodb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerResponse {
    private Integer count;
    private ProductModelServer[] products;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ProductModelServer[] getProducts() {
        return products;
    }

    public void setProducts(ProductModelServer[] productModelServer) {
        this.products = productModelServer;
    }
}
