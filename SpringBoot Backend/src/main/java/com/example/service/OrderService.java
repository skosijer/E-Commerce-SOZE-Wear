package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Order;
import com.example.domain.OrderDetail;
import com.example.repository.OrderDetailRepository;
import com.example.repository.OrderRepository;
import com.example.service.interfaces.OrderServiceInterface;

@Service
public class OrderService implements OrderServiceInterface{
	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	OrderDetailRepository orderDetailRepo;

	@Override
	public Order create(Order order) {
		// TODO Auto-generated method stub
		return orderRepo.save(order);
	}
	
	@Override
	public OrderDetail create(OrderDetail order) {
		// TODO Auto-generated method stub
		return orderDetailRepo.save(order);
	}
	
	
}
