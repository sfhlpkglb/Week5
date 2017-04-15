package com.roeriver.books;


import com.bobswarehouse.BookLookUpService;

public class Warehouse implements InventoryLookup{

	BookLookUpService bookLookUpService = new BookLookUpService();
	
	@Override
	public int retrieveAvailableQuantity(BookItem book) throws BookNotAvailableException{
		
		int inStock =bookLookUpService.lookup(book.getISBN());
		
		if (inStock < 0) {
			throw new BookNotAvailableException("Book not available: " + book.getISBN());
		}
		
		return inStock;
	}

}
