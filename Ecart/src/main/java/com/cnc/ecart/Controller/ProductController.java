package com.cnc.ecart.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.ecart.model.Product;
import com.cnc.ecart.service.ProductService;

@RestController
public class ProductController
{
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add-product")
	public Product addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	
	@GetMapping("/remove-product/productId")
	public String removeProduct(@PathVariable ("productId")int productId)
	{
		if(productService.removeProduct(productId))
		{
			return "success";
		}
		else
		{
			return "unsuccess";
		}
	}
	@GetMapping("/product")
	public List<Product> getProducts()
	{
		return productService.getProducts();
	}
	@GetMapping("/product/{productId}")
	public Product getProduct(@PathVariable ("productId")int productId)
	{
		return productService.getProduct(productId);
	}
	@GetMapping("/product-by-cat/{catId}")
	public List<Product> getProductByCat(@PathVariable("catId")int catId)
	{
		return productService.getProductByCat(catId);
	}

}
