package com.example.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HKVPortfolioFileReader {
	
	public void ReadFile() {		
		//Open file
		String contents = null;
		
		try {
			contents = new String(Files.readAllBytes(Paths.get("src/main/resources/portfolios/wt1.hkp")), StandardCharsets.ISO_8859_1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Split lines
		String[] lines = contents.split("\n");
		
		for(int i = 0; i < lines.length; i++)
		{
			//System.out.println(lines[i]);
			
			//Check line type
			String currentStockName = null;
			if(lines[i].startsWith("#VP")) {
				//Extract stock name and set currentStockName
				currentStockName = ExtractStockName(lines[i]);				 
			}
		}
	}
	
	private String ExtractStockName(String line) {
		//#VP "Nolato B" "" SE0000109811 0 1 
		//Capture stock name
		String pattern = "#VP \"([A-Za-z0-9 ]+)\"";
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
	
//	private HKVTransactionType DetermineTransactionType(String line) {
//		if(line.startsWith("))
//	}
}
