package com.roeriver.books;

public class BookNotAvailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BookNotAvailableException(){
	}
		
	BookNotAvailableException(String message){
		super(message);
	}
	
	BookNotAvailableException(String message, Throwable cause){
		super(message, cause);
	}

	BookNotAvailableException(Throwable cause){
		super(cause);
	}
		
}
