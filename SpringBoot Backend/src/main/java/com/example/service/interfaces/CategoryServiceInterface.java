package com.example.service.interfaces;

import java.util.Collection;

import com.example.domain.Category;

public interface CategoryServiceInterface {
	
	Collection<Category> findAll();
	
	Category create(Category category);
	
	boolean delete(Long id);
}
