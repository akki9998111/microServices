package com.ankit.productService.controller;

import com.ankit.productService.model.ProductRequest;
import com.ankit.productService.model.ProductResponse;
import com.ankit.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping("/addProduct")
    public ResponseEntity<Long>addProduct(@RequestBody ProductRequest productRequest ){

        long productId =productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable long id){
        ProductResponse productResponse= productService.getProductById(id);
        return new ResponseEntity<>(productResponse ,HttpStatus.OK);
    }

    @PutMapping("/reduceQuantity/{productId}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable long productId, @RequestParam long quantity) {
            productService.reduceQuantity(productId , quantity);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
