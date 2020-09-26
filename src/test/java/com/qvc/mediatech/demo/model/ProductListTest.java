package com.qvc.mediatech.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductListTest {
	
	ProductList testList;
	
    @BeforeEach
    public void init() {
    	List<Product> productList = new ArrayList<>();
        productList.add(new Product("A12356", "A product number", "2020-04-23'T'11:35:00"));
        productList.add(new Product("E323456", "E product number", "2020-02-23'T'10:00:00"));
        productList.add(new Product("E789012", "E product number 2", "2021-09-01'T'01:30:00"));
        productList.add(new Product("B123456", "B product number", "2020-12-30'T'03:30:30"));
        productList.add(new Product("A789012", "A product number 2", "2021-04-04'T'09:30:00"));
        productList.add(new Product("C123456", "C product number", "2020-05-15'T'11:01:00"));
        productList.add(new Product("Z1", "Z product number", "2010-01-01'T'01:00:00"));
        productList.add(new Product("A22356", "A product number 3", "2021-04-23'T'11:35:00"));
        productList.add(new Product("E423456", "E product number 3", "2019-02-23'T'10:00:00"));
        productList.add(new Product("E589012", "E product number 4", "2020-12-13'T'01:39:00"));
        testList = new ProductList();
        testList.setProducts(productList);
    }
	
	@Test
	void filterProductListByLetterA() {
		List<Product> filteredListA = new ArrayList<>();
		filteredListA.add(new Product("A12356", "A product number", "2020-04-23'T'11:35:00"));
        filteredListA.add(new Product("A789012", "A product number 2", "2021-04-04'T'09:30:00"));
        filteredListA.add(new Product("A22356", "A product number 3", "2021-04-23'T'11:35:00"));
        ProductList filteredA = new ProductList();
        filteredA.setProducts(filteredListA);
        
		assertTrue(testList.filterProductListByLetter("A"));
		assertEquals(testList, filteredA);
	}
	
	@Test
	void filterProductListByLetterE() {
		List<Product> filteredListE = new ArrayList<>();
        filteredListE.add(new Product("E323456", "E product number", "2020-02-23'T'10:00:00"));
        filteredListE.add(new Product("E789012", "E product number 2", "2021-09-01'T'01:30:00"));
        filteredListE.add(new Product("E423456", "E product number 3", "2019-02-23'T'10:00:00"));
        filteredListE.add(new Product("E589012", "E product number 4", "2020-12-13'T'01:39:00"));
        ProductList filteredE = new ProductList();
        filteredE.setProducts(filteredListE);
        
		assertTrue(testList.filterProductListByLetter("E"));
		assertEquals(testList, filteredE);
	}
	
	@Test
	void sortProductListByLastAired() {
		List<Product> sortedList = new ArrayList<>();
		sortedList.add(new Product("Z1", "Z product number", "2010-01-01'T'01:00:00"));
		sortedList.add(new Product("E423456", "E product number 3", "2019-02-23'T'10:00:00"));
		sortedList.add(new Product("E323456", "E product number", "2020-02-23'T'10:00:00"));
		sortedList.add(new Product("A12356", "A product number", "2020-04-23'T'11:35:00"));
		sortedList.add(new Product("C123456", "C product number", "2020-05-15'T'11:01:00"));
		sortedList.add(new Product("E589012", "E product number 4", "2020-12-13'T'01:39:00"));
		sortedList.add(new Product("B123456", "B product number", "2020-12-30'T'03:30:30"));
		sortedList.add(new Product("A789012", "A product number 2", "2021-04-04'T'09:30:00"));
		sortedList.add(new Product("A22356", "A product number 3", "2021-04-23'T'11:35:00"));
		sortedList.add(new Product("E789012", "E product number 2", "2021-09-01'T'01:30:00"));
        ProductList sortedProducts = new ProductList();
        sortedProducts.setProducts(sortedList);
        
		assertTrue(testList.sortProductListByLastAired());
		assertEquals(testList, sortedProducts);
	}
	
	@Test
	void filterProductListByLetterEAndSortStream() {
		List<Product> filteredListE = new ArrayList<>();
		filteredListE.add(new Product("E423456", "E product number 3", "2019-02-23'T'10:00:00"));
        filteredListE.add(new Product("E323456", "E product number", "2020-02-23'T'10:00:00"));
        filteredListE.add(new Product("E589012", "E product number 4", "2020-12-13'T'01:39:00"));
        filteredListE.add(new Product("E789012", "E product number 2", "2021-09-01'T'01:30:00"));
        ProductList filteredE = new ProductList();
        filteredE.setProducts(filteredListE);
        
		assertTrue(testList.filterProductListByLetterAndSortStream("E"));
		assertEquals(testList, filteredE);
	}
	
	@Test
	void FilterProductListNonExistantLetter() {
		assertFalse(testList.filterProductListByLetter("T"));
	}
	
	@Test
	void FilterProductListStreamNonExistantLetter() {
		assertFalse(testList.filterProductListByLetterAndSortStream("T"));
	}
	
	@Test
	void SortProductListInvalidDate() {
		List<Product> invalidDateList = new ArrayList<>();
		invalidDateList.add(new Product("E423456", "E product number 3", "2009-02-323'T'10:00:00"));
		invalidDateList.add(new Product("E323456", "E product number 4", "22209-02-23'T'10:00:00"));
		invalidDateList.add(new Product("E323556", "E product number 5", "2009-02-23'T'10:0:00"));
		ProductList invalidDateProducts = new ProductList();
	    invalidDateProducts.setProducts(invalidDateList);
	    
	    assertFalse(invalidDateProducts.sortProductListByLastAired());
	}
	
	@Test
	void SortProductListInvalidDateStream() {
		List<Product> invalidDateListS = new ArrayList<>();
		invalidDateListS.add(new Product("E423456", "E product number 3", "2009-02-323'T'10:00:00"));
		invalidDateListS.add(new Product("E323456", "E product number 4", "22209-02-23'T'10:00:00"));
		invalidDateListS.add(new Product("E323556", "E product number 5", "2009-02-23'T'10:0:00"));
		ProductList invalidDateProducts = new ProductList();
	    invalidDateProducts.setProducts(invalidDateListS);
	    
	    assertFalse(invalidDateProducts.filterProductListByLetterAndSortStream("E"));
	}

}
