package com.ankit.productService.service;

import com.ankit.productService.model.ProductRequest;
import com.ankit.productService.model.ProductResponse;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long id);

    void reduceQuantity(long productId, long quantity);
}
