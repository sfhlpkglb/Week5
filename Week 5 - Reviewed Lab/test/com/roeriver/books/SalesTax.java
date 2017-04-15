package com.roeriver.books;

import java.util.HashMap;
import java.util.Map;

public class SalesTax implements StateSalesTax{

	static private Map<String, Double> zipTax = new HashMap<>();
	
	SalesTax(){
		
		zipTax.put("75087", 0.0825);
		zipTax.put("30080", 0.0600);
		zipTax.put("61761", 0.0875);
		zipTax.put("85001", 0.0860);
		
	}
	
	@Override
	public double getStateSalesTaxRate(String zipCode) {
		return zipTax.get(zipCode);
	}

}
