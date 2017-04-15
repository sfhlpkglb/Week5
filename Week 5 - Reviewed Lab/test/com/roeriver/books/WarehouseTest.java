package com.roeriver.books;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class WarehouseTest {

	Warehouse warehouse;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setup(){
		warehouse = new Warehouse();
	}
	
	@Test
	public void testRetrieveAvailableQuantity1() throws BookNotAvailableException {
		int expected = 1;
		Book testBook = new Book("2345", 10.00, "75087");
		int actual = warehouse.retrieveAvailableQuantity(testBook);
		assertEquals(expected, actual);
	}

	@Test
	public void testRetrieveAvailableQuantity2() throws BookNotAvailableException {
		int expected = 0;
		Book testBook = new Book("1399", 15.00, "30080");
		int actual = warehouse.retrieveAvailableQuantity(testBook);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRetrieveAvailableQuantity3() throws BookNotAvailableException {
		int expected = 0;
		Book testBook = new Book("2346", 15.00, "61761");
		int actual = warehouse.retrieveAvailableQuantity(testBook);
		assertEquals(expected, actual);
	}
}
