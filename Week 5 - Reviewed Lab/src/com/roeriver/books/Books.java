package com.roeriver.books;

import java.util.HashMap;
import java.util.Map;

class Books {
	
	static Map<String, BookItem> bookInventory = new HashMap<>();
	
	static private Books instance = new Books();

	private Books(){
	}
	
	static public Books getInstance(){
		return instance;
	}

	boolean addBook(String iSBN, double cost, String zipCode) {

		BookItem book = new Book(iSBN, cost, zipCode);
		boolean returnValue = true;
		
		if(!(bookInventory.containsKey(book.getISBN()))){
			bookInventory.put(book.getISBN(), book);
		} else {
			returnValue = false;
		}
		
		return returnValue;
	}
	
	BookItem findBook(String iSBN){
		return bookInventory.get(iSBN);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (BookItem book : bookInventory.values()) {
			sb.append(book + "\n");
		}
		
		return sb.toString();
	}
	
	
}
