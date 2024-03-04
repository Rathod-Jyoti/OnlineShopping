package com.cnc.ecart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.ecart.model.Delivery;
import com.cnc.ecart.service.DeliveryService;

@RestController
public class DeliveryController
{
	@Autowired 
	private DeliveryService deliveryService;
	
	@PostMapping("/add-delivery")
	public Delivery addDelivery(@RequestBody Delivery delivery) {
		return deliveryService.addDelivery(delivery);
	}

}
