package com.example.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
			}
			else if(lines[i].startsWith("#SÄLJ")) {
				EnsureStockNameIsSet(currentStockName);
			}			
			else if(lines[i].startsWith("#SPLIT")) {
				EnsureStockNameIsSet(currentStockName);
			}			
			else if(lines[i].startsWith("#UTDELNING")) {
				EnsureStockNameIsSet(currentStockName);
			}			
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
