package com.ankit.productService.model;

import lombok.Data;

@Data
public class ProductRequest {

    private String productName;
    private long price;
    private long quantity;
}
