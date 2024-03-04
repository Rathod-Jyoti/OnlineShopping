package com.cnc.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.ecart.Repository.MainCategoryRepository;
import com.cnc.ecart.model.MainCategory;

@Service
public class MainCategoryService 
{
	@Autowired
	private MainCategoryRepository mainCategoryRepository;
	
	public MainCategory addMainCategory(MainCategory mainCat)
	{
		try
		{
			return mainCategoryRepository.save(mainCat);
		}
		catch(Exception ex)
		{
			System.err.println("Exception Occured in addMainCategory: "+ex.getMessage()+"cause: "+ex.getCause());
		}
		return null;
	}
	public boolean removeMainCategory(int mainCatId)
	{
		try
		{
			mainCategoryRepository.deleteById(mainCatId);
			return true;
		}
		catch(Exception ex)
		{
			System.err.println("Exception Occured in removeMainCategory: "+ex.getMessage()+"cause: "+ex.getCause());
		}
		return false;
	}
	public List<MainCategory> getAllMainCategories()
	{
		try
		{
			return mainCategoryRepository.findAll();
		}
		catch(Exception ex)
		{
			System.err.println("Exception Occured in getAllMainCategories:"+ex.getMessage() +"cause: "+ex.getCause());
		}
		return null;
	}

}
