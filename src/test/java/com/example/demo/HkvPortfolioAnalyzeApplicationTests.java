package com.example.demo;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HkvPortfolioAnalyzeApplicationTests {
	
	@Test
	public void ReadFileTest() {
		HKVPortfolioFileReader preader = new HKVPortfolioFileReader();
		
		try {
			preader.ReadFile();	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}		
	}
	
	@Test
	public void SetAndGetStockNameTest() {
		HKVTransaction transaction = new HKVTransaction();
		
		String stockName = "Jonas AB B";
		
		transaction.setStockName(stockName);
		
		Assert.assertEquals(stockName, transaction.getStockName());
	}
}
