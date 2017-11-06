package com.example.demo;

import java.math.BigDecimal;
import java.sql.Date;

public class HKVTransaction {
	private String StockName;
	private Date TransactionDate;
	private BigDecimal Price;
	private BigDecimal TransactionFee;
	private int Amount;
	private HKVTransactionType TransactionType;
	
	public HKVTransaction(String stockName, Date transactionDate, BigDecimal price, BigDecimal transactionFee,
			int amount, HKVTransactionType transactionType) {
		super();
		StockName = stockName;
		TransactionDate = transactionDate;
		Price = price;
		TransactionFee = transactionFee;
		Amount = amount;
		TransactionType = transactionType;
	}
	
	public String getStockName() {
		return StockName;
	}
	public void setStockName(String stockName) {
		StockName = stockName;
	}
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
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public HKVTransactionType getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(HKVTransactionType transactionType) {
		TransactionType = transactionType;
	}	
}
