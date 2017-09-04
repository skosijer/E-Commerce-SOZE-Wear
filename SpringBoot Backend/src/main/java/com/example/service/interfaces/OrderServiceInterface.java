package com.example.service.interfaces;

import java.util.Collection;

import com.example.domain.Order;
import com.example.domain.OrderDetail;

public interface OrderServiceInterface {
	
	Order create(Order order);
	
	OrderDetail create(OrderDetail order);
}
