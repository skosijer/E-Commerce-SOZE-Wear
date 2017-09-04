package com.example.service.interfaces;

import java.util.Collection;

import org.springframework.data.domain.Page;

import com.example.domain.Category;
import com.example.domain.Product;

public interface ProductServiceInterface {
	
	Product findOne(Long id);
	Category findOneCategory(Long id);
	Collection<Product> findAll();
	Page<Product> findAll(int start, int end);
	Page<Product> findAllByCategory(Long id);
	Product create(Product p);
	boolean delete(Long id);
	
}
