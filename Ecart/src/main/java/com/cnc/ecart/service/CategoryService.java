package com.cnc.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.ecart.Repository.CategoryRepository;
import com.cnc.ecart.model.Category;

@Service
public class CategoryService 
{
	@Autowired
	private CategoryRepository categoryRepository;
	
	/*
	 * It will work for insert and update.
	 */
	public Category addCategory(Category category) 
	{
		try 
		{
		return categoryRepository.save(category);	
	    }
		catch (Exception ex) 
		{
			System.err.println("Exception Occured in addCategory : "+ex.getMessage()+" Cause cause "+ex.getCause());  
		}
		return null;
   }
	public boolean removeCategory(int categoryId) {
		try {
		categoryRepository.deleteById(categoryId);
		return true;
		
	}
		catch (Exception ex) {
			System.err.println("Exception Occured in addCategory : "+ex.getMessage()+" cause "+ex.getCause());  
		}
		return false;
	}
	public List<Category> getCategories()
	{
		try
		{
			return categoryRepository.findAll();		
		}
		catch(Exception ex)
		{
			System.err.println("Exception Occured in getCategories :"+ex.getMessage()+" cause: "+ex.getCause());
		}
		return null;
	}
	public Category getCategory(int catId) {
		try {
		return categoryRepository.findById(catId).get();
		
		
	}
		catch (Exception ex) {
			System.err.println("Exception Occured in getCategory : "+ex.getMessage()+" Cause cause "+ex.getCause());  
		}
		return null;
	}
	
	
}
