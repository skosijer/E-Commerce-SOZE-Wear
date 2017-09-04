package com.example.controller;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.OrderDetail;
import com.example.domain.Price;
import com.example.domain.Product;
import com.example.service.PriceService;
import com.example.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	ProductService productService = new ProductService();
	
	@Autowired
	PriceService priceService = new PriceService();
	
	@RequestMapping(
			value = "/getProducts",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Collection<Product>> getAllProducts(){
		
		Collection<Product> products = productService.findAll();
		
		if(products == null){
			return new ResponseEntity<Collection<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Product>>(products,HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getProducts/{start}/{end}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Page<Product>> getAllProducts1(@PathVariable("start") int start, @PathVariable("end") int end){
		
		Page<Product> products = productService.findAll(start,end);
		
		if(products == null){
			return new ResponseEntity<Page<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Page<Product>>(products,HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getProductsByCategory/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Page<Product>> getProductsByCategory(@PathVariable("id") Long id){
		
		Page<Product> products = productService.findAllByCategory(id);
		
		if(products == null){
			return new ResponseEntity<Page<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Page<Product>>(products,HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getProduct/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
		Product product = productService.findOne(id);
		
		if(product == null){
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/getPrices",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public ResponseEntity<Collection<Price>> getPrices(){
		
		Collection<Price> prices = priceService.findAll();
		
		if(prices == null){
			return new ResponseEntity<Collection<Price>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Price>>(prices, HttpStatus.OK);
	}
	
	 @RequestMapping(value="/addProduct",
				method = RequestMethod.POST,
				produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean addProduct(@RequestBody ProductWrapper product)
	{	
		 Product p = new Product();
		 p.setId(product.getId());
		 p.setName(product.getName());
		 p.setDescription(product.getDescription());
		 p.setCreateDate(new Date());
		 p.setCategory(productService.findOneCategory(product.getCategory()));
		 Price price = priceService.findOne(product.getPrice());
		 p.setPrice_id(price);
		 p.setPrice_discount(0);
		 p.setImage("slika");
		 //p.setOrder_details(new HashSet<OrderDetail>());
		 
		 productService.create(p);
		 
		 return true;
	}
	 
	@RequestMapping(value="/deleteProduct",
				method = RequestMethod.POST,
				produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean deleteProduct(@RequestBody Long product_id)
	{
		 productService.delete(product_id);
		 return true;
	} 
}

class ProductWrapper{
	private Long id;
	private String name;
	private String description;
	private Long category;
	private Long price;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
}
