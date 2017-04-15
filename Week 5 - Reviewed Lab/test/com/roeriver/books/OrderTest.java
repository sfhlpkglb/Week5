package com.roeriver.books;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	Order item;
	
	@Before
	public void setup(){
		 item = new Order("2388", ShippingOption.GROUND);
	}
	
	@Test
	public void testGetISBN() {
		String expected = "2388";
		String actual = item.getISBN();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetBaseCost(){
		item.setBaseCost(20.00);
		double expected = 20.00;
		double actual = item.getBaseCost();
		assertEquals(expected, actual, .001);
	}
	
	@Test
	public void testGetShippingOption(){
		String expected = "GROUND";
		String actual = (item.getShippingOption()).toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetSalesTaxPercent(){
		item.setSalesTaxPercent(0.0825);
		double expected = 0.0825;
		double actual = item.getSalesTaxPercent();
		assertEquals(expected, actual, .001);
	}
	
	@Test
	public void testGetBookTotal(){
		item.setBookTotal(100.00);
		double expected = 100.00;
		double actual = item.getBookTotal();
		assertEquals(expected, actual, .001);
	}
	
}
