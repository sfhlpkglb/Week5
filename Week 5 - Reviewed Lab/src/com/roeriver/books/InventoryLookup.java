package com.roeriver.books;

interface InventoryLookup {

	int retrieveAvailableQuantity(BookItem book) throws BookNotAvailableException;
	
}
