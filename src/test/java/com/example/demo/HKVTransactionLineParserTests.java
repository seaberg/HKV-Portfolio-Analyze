package com.example.demo;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HKVTransactionLineParserTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestParseBuyLine() throws Exception {
		//Arrange
		HKVTransactionLineParser lineParser = new HKVTransactionLineParser();		
		String buyLine = "#KÖP 2014-07-16 30 165.5 99 5064";
		
		//There is probably a better way to create a new Date instance
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date transactionDate = dateFormatter.parse("2014-07-16");		
		
		HKVTransaction expectedTransaction = new HKVTransaction();
		expectedTransaction.setStockName("");
		expectedTransaction.setTransactionType(HKVTransactionType.BUY);
		expectedTransaction.setTransactionDate(transactionDate);
		expectedTransaction.setAmount(30);
		expectedTransaction.setPrice(new BigDecimal(165.5));
		expectedTransaction.setTransactionFee(new BigDecimal(99));
		
		//Act
		HKVTransaction actualTransaction = lineParser.ParseBuySellLine(buyLine);
		
		//Assert
		assertEquals(expectedTransaction.getStockName(), actualTransaction.getStockName());
		assertEquals(expectedTransaction.getTransactionType(), actualTransaction.getTransactionType());
		assertEquals(expectedTransaction.getTransactionDate(), actualTransaction.getTransactionDate());
		assertEquals(expectedTransaction.getAmount(), actualTransaction.getAmount());
		assertEquals(expectedTransaction.getPrice(), actualTransaction.getPrice());
		assertEquals(expectedTransaction.getTransactionFee(), actualTransaction.getTransactionFee());
	}
	
	@Test
	public void TestParseSellLine() throws Exception {
		//Arrange
		HKVTransactionLineParser lineParser = new HKVTransactionLineParser();		
		String sellLine = "#SÄLJ 2014-10-10 30 153.5 99 4506";
		
		//There is probably a better way to create a new Date instance
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date transactionDate = dateFormatter.parse("2014-10-10");		
		
		HKVTransaction expectedTransaction = new HKVTransaction();
		expectedTransaction.setStockName("");
		expectedTransaction.setTransactionType(HKVTransactionType.SELL);
		expectedTransaction.setTransactionDate(transactionDate);
		expectedTransaction.setAmount(30);
		expectedTransaction.setPrice(new BigDecimal(153.5));
		expectedTransaction.setTransactionFee(new BigDecimal(99));
		
		//Act
		HKVTransaction actualTransaction = lineParser.ParseBuySellLine(sellLine);
		
		//Assert
		assertEquals(expectedTransaction.getStockName(), actualTransaction.getStockName());
		assertEquals(expectedTransaction.getTransactionType(), actualTransaction.getTransactionType());
		assertEquals(expectedTransaction.getTransactionDate(), actualTransaction.getTransactionDate());
		assertEquals(expectedTransaction.getAmount(), actualTransaction.getAmount());
		assertEquals(expectedTransaction.getPrice(), actualTransaction.getPrice());
		assertEquals(expectedTransaction.getTransactionFee(), actualTransaction.getTransactionFee());		
	}
	
}
