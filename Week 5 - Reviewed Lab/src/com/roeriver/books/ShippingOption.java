package com.roeriver.books;

enum ShippingOption {
	SAME_DAY(0.20), THREE_DAY(0.15), GROUND(0.05), DOWNLOAD(0.00);
	
	private final double shippingIncrement;
	
	ShippingOption(double shippingIncrement){
		this.shippingIncrement = shippingIncrement;
	}
	
	double getShippingIncrement(){
		return shippingIncrement;
	}
}

	
