package com.roeriver.books;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

	BookItem book;
	
	@Before
	public void setup(){
		book = new Book("2345",10.00,"75087");
	}
	
	@Test
	public void testGetISBN() {
		String expected = "2345";
		String actual = book.getISBN();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetCost(){
		double expected = 10.00;
		double actual = book.getCost();
		assertEquals(expected, actual, .001);
	}
	
	@Test
	public void testGetZipCode(){
		String expected = "75087";
		String actual = book.getZipCode();
		assertEquals(expected, actual);
	}
	
	
	

}
