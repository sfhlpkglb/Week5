package com.roeriver.books;

class Order implements OrderItem {
	
	private String iSBN;
	private double baseCost;
	private String zipCode;
	private ShippingOption shippingOption;
	private double salesTaxPercent;
	private double bookTotal;

	Order(String iSBN, ShippingOption shippingOption) {
		
		this(iSBN, shippingOption, null, 0.00, 0.00, 0.00);
		
	}
	
	Order(String iSBN, ShippingOption shippingOption, String zipCode, double baseCost, double salesTaxPercent, double bookTotal){

		this.iSBN = iSBN;
		this.zipCode = zipCode;
		this.shippingOption = shippingOption;
		this.baseCost = baseCost;
		this.salesTaxPercent = salesTaxPercent;
		this.bookTotal = bookTotal;

	}

	@Override
	public String getISBN() {
		return iSBN;
	}

	@Override
	public double getBaseCost() {
		return baseCost;
	}
	
	void setBaseCost(double baseCost){
		this.baseCost = baseCost;
	}
	
	@Override
	public String getZipCode(){
		return zipCode;
	}
	
	@Override
	public ShippingOption getShippingOption() {
		return shippingOption;
	}

	@Override
	public double getSalesTaxPercent() {
		return salesTaxPercent;
	}

	void setSalesTaxPercent(double salesTaxPercent){
		this.salesTaxPercent = salesTaxPercent;
	}
	
	@Override
	public double getBookTotal() {
		return bookTotal;
	}
	
	void setBookTotal(double bookTotal){
		this.bookTotal = bookTotal;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(getISBN() +"\t" + String.format("%.2f", getBaseCost()) + "\t" + getZipCode() + "\t" + getShippingOption().toString() + "\n");
		sb.append(String.format("%.2f", getShippingOption().getShippingIncrement()) + "\t");  
		sb.append(String.format("%.4f",getSalesTaxPercent()) + "\t");
		sb.append(String.format("%.2f", getBookTotal()) +"\n");
		return sb.toString();
	}
}
