package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HkvPortfolioAnalyzeApplicationTests {

//	@Test
//	public void contextLoads() {
//	}
	
	@Test
	public void NumberTest() {
		HKVPortfolioFileReader preader = new HKVPortfolioFileReader();
		
		int result = preader.Number();
		
		Assert.assertEquals(1, result);
	}

}
