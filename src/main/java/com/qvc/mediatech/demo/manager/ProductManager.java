package com.qvc.mediatech.demo.manager;

import com.qvc.mediatech.demo.dao.ProductDao;
import com.qvc.mediatech.demo.model.Product;
import com.qvc.mediatech.demo.model.ProductList;
import org.springframework.stereotype.Component;

@Component
public class ProductManager {

    ProductDao productDao;



    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }



    public Product getProduct(String productNumber) {
        return productDao.findByProductNumber(productNumber);

    }



    public ProductList getAllProducts() {

        ProductList productList = new ProductList();
        productList.setProducts(productDao.getAllProducts());

        return productList;
    }
}
