package com.cnc.ecart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.ecart.model.Order;
import com.cnc.ecart.service.OrderService;

@RestController
public class OrderController 
{
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/add-order")
	public Order addOrder(@RequestBody Order order) {
	 return orderService.addOrder(order);
	}
	
	@GetMapping("cancel-order/{orderId}")
	public boolean cancelOrder(@PathVariable("orderId") int orderId) {
		return orderService.cancelOrder(orderId);
	}
	@GetMapping("/orders")
	public List<Order> getOrders() {
		return orderService.getOrders();
	}
	@GetMapping("/order/{orderId}")
	public Order getOrder(@PathVariable("orderId") int orderId) {
		return orderService.getOrder(orderId);
	}

}
