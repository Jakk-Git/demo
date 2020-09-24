package com.qvc.mediatech.demo.config;

import com.qvc.mediatech.demo.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProductListConfig {

    @Bean
    public List<Product> initProductList() {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product("A123456", "A product number", "2020-01-01'T'12:00:00"));
        productList.add(new Product("A789012", "A product number 2", "2020-01-01'T'12:30:00"));
        productList.add(new Product("B123456", "B product number", "2020-02-01'T'12:00:00"));
        productList.add(new Product("B789012", "B product number 2", "2020-02-01'T'12:30:00"));
        productList.add(new Product("C123456", "C product number", "2020-03-01'T'12:00:00"));
        productList.add(new Product("C789012", "C product number 2", "2020-03-01'T'12:30:00"));
        productList.add(new Product("D123456", "D product number", "2020-04-01'T'12:00:00"));
        productList.add(new Product("D789012", "D product number 2", "2020-04-01'T'12:30:00"));
        productList.add(new Product("E123456", "E product number", "2020-04-01'T'12:00:00"));
        productList.add(new Product("E789012", "E product number 2", "2020-04-01'T'12:30:00"));

        return productList;
    }

}
