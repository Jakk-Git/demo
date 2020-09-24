package com.qvc.mediatech.demo.dao;

import com.qvc.mediatech.demo.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class ProductDao {
    private List<Product> productList;


    public ProductDao(List<Product> productList) {
        this.productList = productList;
    }



    public Product findByProductNumber(String productNumber) {
        Product returnProduct = new Product();

        for (Product product : productList) {
            if (productNumber.equalsIgnoreCase(product.getProductNumber())) {
                returnProduct = product;
            }
        }

        return returnProduct;
    }



    public List<Product> getAllProducts() {
        return productList;
    }
}
