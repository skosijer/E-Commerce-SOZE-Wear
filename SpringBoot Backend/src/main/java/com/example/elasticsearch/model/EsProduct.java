package com.example.elasticsearch.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "products", type = "products", shards = 1)
public class EsProduct {
	
	 @Id
	 @GeneratedValue
	 private Long id;
	 
	 private String name;
	 private String description;
	 private String category;
	 private int price;
	 private int discount;
	 
	public EsProduct()
	{
		
	}
	 
	public EsProduct(Long id, String name, String description, String category, int price, int discount) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.discount = discount;
	}
	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	 
	 
}
