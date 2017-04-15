package com.roeriver.books;

class Book implements BookItem {
	
	private String iSBN;
	private double cost;
	private String zipCode;
	
	Book(String iSBN, double cost, String zipCode) {

		this.iSBN = iSBN;
		this.cost = cost;
		this.zipCode = zipCode;
	}

	@Override
	public String getISBN() {
		return iSBN;
	}

	@Override
	public double getCost() {
		return cost;
	}

	@Override
	public String getZipCode() {
		return zipCode;
	}

	@Override
	public String toString() {
		return "iSBN: " + getISBN() + ", cost: " + String.format("%.2f", getCost()) + ", zip code: "
				+ getZipCode();
	}
	
	

}
