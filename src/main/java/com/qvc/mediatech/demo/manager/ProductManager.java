package com.qvc.mediatech.demo.manager;

import com.qvc.mediatech.demo.dao.ProductDao;
import com.qvc.mediatech.demo.model.Product;
import com.qvc.mediatech.demo.model.ProductList;
import org.springframework.stereotype.Component;

@Component
public class ProductManager {
    final ProductDao productDao;

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
    
    public ProductList getAllProductsStartingWithA() {
        ProductList productList = new ProductList();
        productList.setProducts(productDao.getAllProducts());
        productList.filterProductListByLetter("A");
        return productList;
    }
    
    
    public ProductList getAllProductsSortedByLastAired() {
        ProductList productList = new ProductList();
        productList.setProducts(productDao.getAllProducts());
        productList.sortProductListByLastAired();
        return productList;
    }
    
    public ProductList getAllProductsSortedAndFilteredByA() {
        ProductList productList = new ProductList();
        productList.setProducts(productDao.getAllProducts());
        productList.filterProductListByLetterAndSortStream("A");
        return productList;
    }
}
