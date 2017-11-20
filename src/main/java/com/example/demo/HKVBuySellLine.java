package com.example.demo;

import java.math.BigDecimal;
import java.util.Date;

public class HKVBuySellLine extends HKVLine {
	private Date TransactionDate;
	private BigDecimal Price;
	private BigDecimal TransactionFee;
	private int volume;
	
	public Date getTransactionDate() {
		return TransactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		TransactionDate = transactionDate;
	}
	public BigDecimal getPrice() {
		return Price;
	}
	public void setPrice(BigDecimal price) {
		Price = price;
	}
	public BigDecimal getTransactionFee() {
		return TransactionFee;
	}
	public void setTransactionFee(BigDecimal transactionFee) {
		TransactionFee = transactionFee;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
}
