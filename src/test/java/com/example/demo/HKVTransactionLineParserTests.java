package com.example.demo;

import static org.junit.Assert.*;

import java.util.Calendar;
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
	public void TestParseBuyLine() {
		//Arrange
		String buyLine = "#KÖP 2014-07-16 30 165.5 99 5064";
		
		HKVTransaction expectedTransaction = new HKVTransaction();
		
		//Act
		
		//Assert
		assert(true);
	}

}
