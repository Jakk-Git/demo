package com.qvc.mediatech.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductList {

    @JsonProperty("productList")
    private List<Product> products;
    
    @JsonIgnore
    private Comparator<Product> sortByLastAired = (Product p1, Product p2) -> {
    	try {	
    	SimpleDateFormat lastAiredFormat = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
    	lastAiredFormat.setLenient(false);
    	Date p1Date = lastAiredFormat.parse(p1.getLastAired().replace("'T'", ""));
    	Date p2Date = lastAiredFormat.parse(p2.getLastAired().replace("'T'", ""));
    	return (p1Date.compareTo(p2Date));
		} catch (ParseException e) {
			throw new RuntimeException("Error parsing date of " + p1.getLastAired() + " and " + p2.getLastAired() + " : " + e.getMessage());
		}
    };
    
    public boolean filterProductListByLetter(String productLetter)
    {
    	List<Product> productsToRemove = new ArrayList<>();
	    for(Product p:products)
	    {
	    	if(!p.getProductNumber().startsWith(productLetter))
	    	{
	    		productsToRemove.add(p);
	    	}
	    }
	    products.removeAll(productsToRemove);
	    return !products.isEmpty();
    }
    
    public boolean sortProductListByLastAired()
    {
    	try {
	    	products.sort(sortByLastAired);
	    	return true;
    	}
    	catch(RuntimeException e) {
    		Logger.getGlobal().log(Level.WARNING, "Error sorting Product List.", e);
    		return false;
    	}
    }
    
    public boolean filterProductListByLetterAndSortStream(String productLetter)
    {
    	try {
	    	products = products.stream().filter(p -> p.getProductNumber().startsWith(productLetter)).sorted(sortByLastAired).collect(Collectors.toList());
	    	return !products.isEmpty();
    	}
    	catch(RuntimeException e)
    	{
    		Logger.getGlobal().log(Level.WARNING, "Error sorting Product List with stream.", e);
    		return false;
    	}
    	
    }
}
