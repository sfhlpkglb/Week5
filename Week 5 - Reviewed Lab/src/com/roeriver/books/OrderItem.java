package com.roeriver.books;

interface OrderItem {

	String getISBN();

	double getBaseCost();
	
	String getZipCode();

	ShippingOption getShippingOption();

	double getSalesTaxPercent();

	double getBookTotal();

}
