package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Category;
import com.example.repository.CategoryRepository;
import com.example.service.interfaces.CategoryServiceInterface;

@Service
public class CategoryService implements CategoryServiceInterface{
	
	@Autowired
	CategoryRepository categoryRepo;

	@Override
	public Collection<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	@Override
	public Category create(Category category) {
		// TODO Auto-generated method stub
		return categoryRepo.save(category);
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		categoryRepo.delete(id);
		return true;
	}
}
