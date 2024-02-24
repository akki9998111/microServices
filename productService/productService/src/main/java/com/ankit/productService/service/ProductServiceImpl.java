package com.ankit.productService.service;

import com.ankit.productService.entity.Product;
import com.ankit.productService.exception.ProductCustomException;
import com.ankit.productService.model.ProductRequest;
import com.ankit.productService.model.ProductResponse;
import com.ankit.productService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("adding product");

        Product product = Product.builder().productName(productRequest.getProductName())
                .price(productRequest.getPrice()).quantity(productRequest.getQuantity()).build();

        Product save = productRepository.save(product);
        log.info(" product added");
        return save.getProductId();
    }

    @Override
    public ProductResponse getProductById(long id) {
        Product referenceById = productRepository.findById(id).orElseThrow(() -> new ProductCustomException("Product not found", "NOT_FOUND"));
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(referenceById, productResponse);
        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("reduce quantity for productId::{} and qantity ::{}", productId, quantity);

        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ProductCustomException("Product with given Id not found", "Product_Not_Found"));
        if (product.getQuantity()< quantity){
            throw new ProductCustomException("Product does not have sufficient quantity", "Insufficient_Quantity");
        }
        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
        log.info("product quantity updated successfully");
    }
}
