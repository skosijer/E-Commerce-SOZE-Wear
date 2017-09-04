package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Order;
import com.example.domain.OrderDetail;
import com.example.domain.User;
import com.example.service.OrderService;
import com.example.service.ProductService;
import com.example.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	
	@Autowired
	private OrderService orderService = new OrderService();
	
	@Autowired
	private UserService userService = new UserService();
	
	@Autowired
	private ProductService productService = new ProductService();


	@RequestMapping(value="/makeOrder",
					method = RequestMethod.POST,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean makeOrder(@RequestBody OrderWrapper order_details)
	{
		Order order = new Order();
		
		User u = userService.findOneAuthId(order_details.getUser_id());
		
		order.setCustomerAddress(order_details.getAddress());
		order.setCustomerEmail(order_details.getEmail());
		order.setCustomerName(u.getFirstName() + " " + u.getLastName());
		order.setCustomerPhone(order_details.getPhone());
		order.setOrderDate(new Date());
		order.setUser_id(u);
		
		order = orderService.create(order);
		
		for(ProdQuanSize pqs : order_details.getOrders())
		{
			OrderDetail od = new OrderDetail();
			
			od.setProduct_id(productService.findOne(pqs.getProduct_id()));
			od.setOrder_id(order);
			od.setQuantity(pqs.getQuantity());
			od.setPrice(0);
			od.setProduct_size((pqs.getSize()));
			
			//System.out.println("prod id " + od.getProduct_id().getId() + " order id" + od.getOrder_id().getId() + " price " + od.getPrice());
			
			orderService.create(od);
		}
		
		return true;
	}
}

class OrderWrapper{
	
	private String user_id;
	private String email;
	private String address;
	private String phone;
	private List<ProdQuanSize> orders;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public List<ProdQuanSize> getOrders() {
		return orders;
	}
	public void setOrders(List<ProdQuanSize> orders) {
		this.orders = orders;
	}
}

class ProdQuanSize{
	
	private Long product_id;
	private String size;
	private int quantity;
	
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
