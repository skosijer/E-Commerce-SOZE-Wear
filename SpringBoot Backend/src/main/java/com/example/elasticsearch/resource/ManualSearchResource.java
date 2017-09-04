package com.example.elasticsearch.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Product;
import com.example.elasticsearch.builder.SearchQueryBuilder;
import com.example.elasticsearch.model.EsProduct;
import com.example.repository.ProductRepository;

@RestController
@RequestMapping("/rest/manual/search")
@CrossOrigin(origins = "http://localhost:4200")
public class ManualSearchResource {

    @Autowired
    private SearchQueryBuilder searchQueryBuilder;
    
    @Autowired
    private ProductRepository productRepo;

//    @GetMapping(value = "/{text}")
//    public Collection<EsProduct> getAllProducts(@PathVariable final String text) {
//        return searchQueryBuilder.getAllProducts(text);
//    }
    
    @RequestMapping(value="/firstSearch",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Product> productsFirstSearch(@RequestBody final FirstSearchWrapper fsw) {
    	
        Collection<EsProduct> esProducts = searchQueryBuilder.productsFirstSearch(fsw.getText(), fsw.isName(), fsw.isDescription(), fsw.isCategory());
        
        Collection<Product> products = new ArrayList<Product>();
        
        Iterator<EsProduct> iterator = esProducts.iterator();
		 
		 while(iterator.hasNext())
			{
				Product p = productRepo.findOne(iterator.next().getId());
				products.add(p);
			}
        
        return products;
    }
    
    @RequestMapping(value="/secondSearch",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Product> productsSecondSearch(@RequestBody final FirstSearchWrapper fsw) {
    	
        Collection<EsProduct> esProducts = searchQueryBuilder.productsSecondSearch(fsw.getText(), fsw.isName(), fsw.isDescription(), fsw.isCategory());
        
        Collection<Product> products = new ArrayList<Product>();
        
        Iterator<EsProduct> iterator = esProducts.iterator();
		 
		 while(iterator.hasNext())
			{
				Product p = productRepo.findOne(iterator.next().getId());
				products.add(p);
			}
        
        return products;
    }
  
    @RequestMapping(value="/thirdSearch",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
//    @GetMapping(value = "/{text}")
    public Collection<Product> productsThirdSearch(@RequestBody final FirstSearchWrapper text) {
    	
        Collection<EsProduct> esProducts = searchQueryBuilder.productsThirdSearch(text.getText());
        
        Collection<Product> products = new ArrayList<Product>();
        
        Iterator<EsProduct> iterator = esProducts.iterator();
		 
		 while(iterator.hasNext())
			{
				Product p = productRepo.findOne(iterator.next().getId());
				products.add(p);
			}
        
        return products;
    }
}

class FirstSearchWrapper 
{
	private String text;
	private boolean name;
	private boolean description;
	private boolean category;
	
	public FirstSearchWrapper()
	{
		
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isName() {
		return name;
	}
	public void setName(boolean name) {
		this.name = name;
	}
	public boolean isDescription() {
		return description;
	}
	public void setDescription(boolean description) {
		this.description = description;
	}
	public boolean isCategory() {
		return category;
	}
	public void setCategory(boolean category) {
		this.category = category;
	}
}