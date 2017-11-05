package com.example.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HKVPortfolioFileReader {
	
	public void ReadFile() {
		System.out.println("Hej hej!");
		
		//Open file
		String contents = null;
		
		try {
			contents = new String(Files.readAllBytes(Paths.get("src/main/resources/portfolios/wt1.hkp")), StandardCharsets.ISO_8859_1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(contents);
		
		//Split lines
		String[] lines = contents.split("\n");
		
		for(int i = 0; i < lines.length; i++)
		{
			System.out.println(lines[i]);
		}
		
		//Check line transaction type
	}
	
	public int Number() {
		return 1;
	}
}
