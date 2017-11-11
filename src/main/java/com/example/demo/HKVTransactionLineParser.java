package com.example.demo;

public class HKVTransactionLineParser {
	private static final String BASE_BUY_SELL_PATTERN = "([0-9-]+) ([0-9]+) ([0-9.]+) ([0-9.]+) ([0-9.]+)"; 
	
	public HKVTransaction ParseBuySellLine(String line) {
		return new HKVTransaction();
	}
	
	private String GetBuyPattern() {
		return "#KÖP " + BASE_BUY_SELL_PATTERN;
	}
	
	private String GetSellPattern() {
		return "#SÄLJ " + BASE_BUY_SELL_PATTERN;
	}
}
