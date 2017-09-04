package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Price;
import com.example.repository.PriceRepository;
import com.example.service.interfaces.PriceServiceInterface;

@Service
public class PriceService implements PriceServiceInterface {
	
	@Autowired
	PriceRepository priceRepo;

	@Override
	public Collection<Price> findAll() {
		// TODO Auto-generated method stub
		return priceRepo.findAll();
	}

	@Override
	public Price findOne(Long id) {
		// TODO Auto-generated method stub
		return priceRepo.findOne(id);
	}
	
	
}
