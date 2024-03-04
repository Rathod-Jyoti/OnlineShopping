package com.cnc.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.ecart.Repository.OrderRepository;
import com.cnc.ecart.model.Order;

@Service
public class OrderService 
{
	@Autowired
	private OrderRepository orderRepository;
	
	public Order addOrder(Order order) {
		try {
			
			orderRepository.save(order);
		}
		catch (Exception ex) {
			System.err.println("Exception Occured in addOrder:"+ex.getMessage()+"Cause: "+ex.getCause());
			
		}
		return null;
	}
	public boolean cancelOrder(int orderId) {
		try {
			if(orderRepository.cancelOrder(orderId)<0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ex) {
			System.err.println("Exception Occured in cancelOrder:"+ex.getMessage()+" cause:"+ex.getCause());
		}
		return false;
	}
	public List<Order> getOrders(){
		try {
		return orderRepository.findAll();
		}
		catch (Exception ex) {
			System.err.println("Exception Occured in getOrders: "+ex.getMessage()+"cause: "+ex.getCause());
			
		}
		return null;
	}
	public Order getOrder(int orderId){
		try {
		if(orderId!=0) {
		return orderRepository.findById(orderId).get();
		}
		}
		catch (Exception ex) {
			System.err.println("Exception Occured in getOrder: "+ex.getMessage()+"cause: "+ex.getCause());
		}
		return null;
	}

}
