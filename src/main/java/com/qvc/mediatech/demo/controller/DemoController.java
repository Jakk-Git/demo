package com.qvc.mediatech.demo.controller;

import com.qvc.mediatech.demo.manager.ProductManager;
import com.qvc.mediatech.demo.model.Product;
import com.qvc.mediatech.demo.model.ProductList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Validated
@RequestMapping(value = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {
    ProductManager productManager;

    public DemoController(ProductManager productManager) {
        this.productManager = productManager;
    }



    @GetMapping(value = "/product/{productNumber}")
    public ResponseEntity<Product> getProduct(@PathVariable String productNumber) {

        try {
            return new ResponseEntity<>(productManager.getProduct(productNumber), HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    @GetMapping(value = "/product-list")
    public ResponseEntity<ProductList> getProducts() {

        try {
            return new ResponseEntity<>(productManager.getAllProducts(), HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


}
