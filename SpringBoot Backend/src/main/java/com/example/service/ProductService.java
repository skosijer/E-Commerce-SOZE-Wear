package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.domain.Category;
import com.example.domain.Product;
import com.example.repository.CategoryRepository;
import com.example.repository.ProductRepository;
import com.example.service.interfaces.ProductServiceInterface;

@Service
public class ProductService implements ProductServiceInterface {
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository categoryRepo;

	@Override
	public Product findOne(Long id) {
		// TODO Auto-generated method stub
		return productRepo.findOne(id);
	}

	@Override
	public Collection<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Page<Product> findAllByCategory(Long id) {
		// TODO Auto-generated method stub
		return productRepo.findByCategoryId(id, new PageRequest(0, 2));
	}

	@Override
	public Page<Product> findAll(int start, int end) {
		// TODO Auto-generated method stub
		return productRepo.findAll(new PageRequest(start, end));
	}

	@Override
	public Product create(Product p) {
		// TODO Auto-generated method stub
		return productRepo.save(p);
	}

	@Override
	public Category findOneCategory(Long id) {
		// TODO Auto-generated method stub
		return categoryRepo.findOne(id);
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		productRepo.delete(id);
		return true;
	}
}
