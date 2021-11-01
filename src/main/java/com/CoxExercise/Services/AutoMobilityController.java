package com.CoxExercise.Services;

import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.*;
import java.io.FileNotFoundException;
import java.util.HashMap;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;


@RestController
public class AutoMobilityController{

	private int requestNum = 0;
	
	@GetMapping("/hello")
	public String getTest(){
		
		Stock stock;
		try{
		stock = YahooFinance.get("INTC");
 
		BigDecimal price = stock.getQuote().getPrice();
		BigDecimal change = stock.getQuote().getChangeInPercent();
		BigDecimal peg = stock.getStats().getPeg();
		BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
		 
		stock.print();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Hello world";
	}
	
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4200/stock"})
	@GetMapping("/stock")
	public Stock getStock(@RequestParam(value = "lookingItem", defaultValue = "") String lookingItem){
		System.out.println("\n\n\n\n\n\n\n" + requestNum + "\n\n\n");
		requestNum++;
		Stock stock = null;
		try{
			stock = YahooFinance.get(lookingItem);
		
		}catch(Exception e){
			e.printStackTrace();
		//}catch(FileNotFoundException fe){
			//System.out.println("\n\n\n\n\n\n\n-----------------Juan test-----------------\n\n\n");
			//fe.printStackTrace();
		}finally{
			return stock;
		}
	}
	
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4200/stock"})
	@GetMapping("/stocks")
	public HashMap<String, Stock> getStocks(@RequestParam(value = "lookingItems", defaultValue = "") String lookingItems){
		System.out.println("\n\n\n\n\n\n\n" + requestNum + "\n\n\n");
		requestNum++;
		String[] items = new String[1];
		HashMap<String, Stock> stocks = new HashMap<String, Stock>();
		try{
			items = lookingItems.split(",");
			stocks = (HashMap<String, Stock>)YahooFinance.get(items);
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return stocks;
		}
	}
}