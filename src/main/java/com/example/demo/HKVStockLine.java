package com.example.demo;

public class HKVStockLine extends HKVLine {
	private String StockName;
	
	private final String PATTERN = "#VP \"([A-Za-z0-9åäöÅÄÖ.& ]+)\"";

	public String getStockName() {
		return StockName;
	}

	public void setStockName(String stockName) {
		StockName = stockName;
	}
}
