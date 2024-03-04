package com.cnc.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.ecart.Repository.StockRepository;
import com.cnc.ecart.model.Stock;

@Service
public class StockService
{
	@Autowired
	private StockRepository stockRepository;
	
	public Stock addStock(Stock stock)
	{
		try
		{
			return stockRepository.save(stock);
		}
		catch(Exception ex)
		{
			System.err.println("Exception Occured in addStock: "+ex.getMessage()+"cause: "+ex.getCause());
		}
		return null;
	}
	public boolean deleteStock(int stockId) {
		try {
			stockRepository.deleteById(stockId);
			return true;
		} 
		catch (Exception ex) {
			System.err.println("Exception Occured in StockService.deleteStock:"+ex.getMessage()+" Cause: "+ex.getCause());
		}
		return false;
	}
	
	public List<Stock> getStocks(){
		try {
			return stockRepository.findAll();
		}
		catch (Exception ex) {
			System.err.println("Exception Occured in getStock: "+ex.getMessage()+" Cause: "+ex.getCause());
		
		}
		return null;
	}

	public  Stock getStock(int stockId) {
		try {
			return stockRepository.findById(stockId).get();
		}
		catch (Exception ex) {
			System.err.println("Exception Occured in getStock: "+ex.getMessage()+"Cause: "+ex.getMessage());
		}
		return null;
	}

}
