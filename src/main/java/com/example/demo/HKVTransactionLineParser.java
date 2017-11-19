package com.example.demo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HKVTransactionLineParser {
	private static final String BUY_SELL_PATTERN = "(#KÖP|#SÄLJ) ([0-9-]+) ([0-9]+) ([0-9.]+) ([0-9.]+) ([0-9.]+)"; 
	
	public HKVTransaction ParseBuySellLine(String line) throws Exception {
		//#KÖP 2014-07-16 30 165.5 99 5064
		//String buyPattern = "#KÖP ([0-9-]+) ([0-9]+) ([0-9.]+) ([0-9.]+) ([0-9.]+)";
		Pattern regex = Pattern.compile(BUY_SELL_PATTERN);
		Matcher m = regex.matcher(line);
		
		if(m.find()) {
//			System.out.println("Date: " + m.group(1));
//			System.out.println("Volume: " + m.group(2));
//			System.out.println("Price: " + m.group(3));
//			System.out.println("Fee: " + m.group(4));
//			System.out.println("Amount: " + m.group(5));
//			System.out.println("**********************");
			
			HKVTransactionType transactionType;
			String transactionTypeString = m.group(1);
			if(transactionTypeString.equals("#KÖP")) {
				transactionType = HKVTransactionType.BUY;
			}
			else if(transactionTypeString.equals("SÄLJ")) {
				transactionType = HKVTransactionType.SELL;
			}
			else {
				throw new Exception("Cannot handle transaction type: " + transactionTypeString);
			}
			
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormatter.parse(m.group(2));
			int volume = Integer.parseInt(m.group(3));
			BigDecimal price = new BigDecimal(m.group(4));
			BigDecimal fee = new BigDecimal(m.group(5));			
			
			HKVTransaction transaction = new HKVTransaction("",
					date,
					price,
					fee,
					volume,
					transactionType);
			return transaction;
		}
		else
		{
			throw new Exception("Unabled to parse transaction from line: " + line);
		}		
	}
}
