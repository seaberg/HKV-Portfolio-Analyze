package com.example.demo;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HKVPortfolioFileReader {
	public void ReadFile() throws IOException {		
		//Read file
		String contents = null;
		
		try {
			contents = new String(Files.readAllBytes(Paths.get("src/main/resources/portfolios/wt1.hkp")), StandardCharsets.ISO_8859_1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Split lines
		String[] lines = contents.split("\n");
		
		String currentStockName = null;
		Vector<HKVTransaction> transactions = new Vector<HKVTransaction>();
		
		for(int i = 0; i < lines.length; i++)
		{
			//System.out.println(lines[i]);
			
			//Check line type	
			if(lines[i].startsWith("#VP")) {
				//Extract stock name and set currentStockName
				currentStockName = ExtractStockName(lines[i]);				 
			}
			else if(lines[i].startsWith("#KÖP")) {
				EnsureStockNameIsSet(currentStockName);
				//Capture info from line
				//#KÖP 2014-07-16 30 165.5 99 5064
				try {
					transactions.add(ParseTransactionFromLine(currentStockName, lines[i]));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(lines[i].startsWith("#SÄLJ")) {
				EnsureStockNameIsSet(currentStockName);
				//Capture info from line
				//#SÄLJ 2014-10-10 30 153.5 99 4506
			}			
			else if(lines[i].startsWith("#SPLIT")) {
				EnsureStockNameIsSet(currentStockName);
			}			
			else if(lines[i].startsWith("#UTDELNING")) {
				EnsureStockNameIsSet(currentStockName);
			}			
		}
	}
	
	private HKVTransaction ParseTransactionFromLine(String stockName, String line) throws Exception {
		//#KÖP 2014-07-16 30 165.5 99 5064
		String buyPattern = "#KÖP ([0-9-]+) ([0-9]+) ([0-9.]+) ([0-9.]+) ([0-9.]+)";
		Pattern regex = Pattern.compile(buyPattern);
		Matcher m = regex.matcher(line);
		
		if(m.find()) {
//			System.out.println("Date: " + m.group(1));
//			System.out.println("Volume: " + m.group(2));
//			System.out.println("Price: " + m.group(3));
//			System.out.println("Fee: " + m.group(4));
//			System.out.println("Amount: " + m.group(5));
//			System.out.println("**********************");
			
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormatter.parse(m.group(1));
			int volume = Integer.parseInt(m.group(2));
			BigDecimal price = new BigDecimal(m.group(3));
			BigDecimal fee = new BigDecimal(m.group(4));			
			
			HKVTransaction transaction = new HKVTransaction(stockName,
					date,
					price,
					fee,
					volume,
					HKVTransactionType.BUY);
			return transaction;
		}
		else
		{
			throw new Exception("Unabled to parse transaction from line: " + line);
		}
	}
	
	private String ExtractStockName(String line) {
		//#VP "Nolato B" "" SE0000109811 0 1 
		//Capture stock name
		String pattern = "#VP \"([A-Za-z0-9åäöÅÄÖ.& ]+)\"";
		Pattern regex = Pattern.compile(pattern);
		Matcher m = regex.matcher(line);
		
		if(m.find()) {
			System.out.println("Stock name: " + m.group(1));
			return m.group(1);
		}
		else
		{
			return null;
		}
	}
	
	private void EnsureStockNameIsSet(String currentStockName) throws IOException {
		if(currentStockName == null) {
			throw new IOException("CurrentStockName not set!");
		}
	}
}
