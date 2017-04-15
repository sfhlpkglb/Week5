package com.roeriver.books;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class BooksTest {

	Books books;
	
	@Before
	public void setup(){
		books = Books.getInstance();
	}
	
	@Test
	public void testAddBook() {
		books.addBook("2345", 10.00, "75087");
		String expected = "iSBN: 2345, cost: 10.00, zip code: 75087";
		String actual = books.findBook("2345").toString();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddDuplicateItem(){
		books.addBook("2388", 20.00, "75087");
		assertFalse(books.addBook("2388", 20.00, "75087"));
	}
	
	@Test
	public void testToString(){
		books.addBook("2345", 10.00, "75087");
		books.addBook("2388", 20.00, "75087"); 
		String expected = "iSBN: 2345, cost: 10.00, zip code: 75087\n" +
				"iSBN: 2388, cost: 20.00, zip code: 75087\n";
		String actual = books.toString();
		assertEquals(expected, actual);
	}

}
