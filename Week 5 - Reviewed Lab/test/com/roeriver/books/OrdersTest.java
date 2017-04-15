package com.roeriver.books;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrdersTest {

	static Books books = Books.getInstance();
	
	Orders orders = new Orders();
	
	@BeforeClass
	static public void startup(){
		new LoadBooks(books);
	}
	
	@Before
	public void setup(){
		
	}
	
	@Test
	public void testCreateOrder() {
		int expected = orders.getNextOrderNumber();
		int actual = orders.createNewOrder();
		assertEquals(expected, actual);
	}

	@Test
	public void testAddToOrder() throws BookNotAvailableException{
		int orderNumber = orders.createNewOrder();
		assertTrue(orders.addToOrder(orderNumber, "2345",ShippingOption.DOWNLOAD));
		String expected = "2345\t10.00\t75087\tDOWNLOAD\n0.00\t0.0825\t10.83\n";
		String actual = orders.listOrder(orderNumber);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testOrderTotal() throws BookNotAvailableException{
		int orderNumber = orders.createNewOrder();
		assertTrue(orders.addToOrder(orderNumber, "2345",ShippingOption.DOWNLOAD));
		assertTrue(orders.addToOrder(orderNumber, "2388", ShippingOption.GROUND));
		assertTrue(orders.addToOrder(orderNumber, "1399", ShippingOption.DOWNLOAD));
		double expected = 49.37;
		double actual = orders.orderTotal(orderNumber);
		assertEquals(expected, actual, .005);		
	}
	
	@Test
	public void testOrderSize() throws BookNotAvailableException{
		int orderNumber = orders.createNewOrder();
		assertTrue(orders.addToOrder(orderNumber, "2345",ShippingOption.DOWNLOAD));
		assertTrue(orders.addToOrder(orderNumber, "2388", ShippingOption.GROUND));
		int expected = 2;
		int actual = orders.orderSize(orderNumber);
		assertEquals(expected, actual);
	}
	

}
