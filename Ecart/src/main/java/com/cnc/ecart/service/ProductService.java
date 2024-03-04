package com.cnc.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.ecart.Repository.ProductRepository;
import com.cnc.ecart.model.Product;

@Service
public class ProductService
{
	@Autowired
	private ProductRepository productRepository;
	
	/*
	 * Insert and update
	 */
	public Product addProduct(Product product) 
	{
		try 
		{
		return productRepository.save(product);
		}
		catch (Exception ex) 
		{
			System.err.println("Exception Occured in addProduct:"+ex.getMessage()+" cause:"+ex.getCause());
		}
		return null;
	}
	
	public boolean removeProduct(int productId)
	{
		try
		{
		productRepository.deleteById(productId);
		return true;
		}
		catch(Exception ex) 
		{
			System.err.println("Exception Occured in removeProduct: "+ex.getMessage()+"cause: "+ex.getCause());
		}
		return false;
	}
	public List<Product> getProducts()
	{
		try 
		{
			return productRepository.findAll();
			}
		catch (Exception ex)
		{
			System.err.println("Exception Occured in getProducts:"+ex.getMessage()+"cause:"+ex.getCause());
		}
		return null;
	}
	public Product getProduct(int productId) 
	{
		try 
		{
			return productRepository.findById(productId).get();
		}
		catch (Exception ex) 
		{
			System. err.println("Exception Occured in getProduct: "+ex.getMessage()+" cause: cause: "+ex.getCause());
		}
		return null;
		
	}
	public List<Product> getProductByCat(int catId)
	{
		return productRepository.findByCatId(catId);
	}
	

}
