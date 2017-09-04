package com.example.service.interfaces;

import java.util.Collection;

import com.example.domain.Price;

public interface PriceServiceInterface {
	
	Collection<Price> findAll();
	Price findOne(Long id);
}
