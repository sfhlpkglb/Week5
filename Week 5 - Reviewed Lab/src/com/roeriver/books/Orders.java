package com.roeriver.books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Orders {
	
	static private int nextOrder;
	
	static private Map<Integer, List<Order>> orders;
	
	static Books books = Books.getInstance();
	
	static Warehouse warehouse = new Warehouse();
	
	static StateSalesTax salesTax = new SalesTax();
	
	//		CONSTRUCTOR
	Orders(){
		nextOrder = 1;
		orders = new HashMap<>();
	}
	
	//		Method - getNextOrderNumber - pass the next invoice number to the caller
	//			input - none
	//			output
	//				int	next order number		
	public int getNextOrderNumber() {
		return nextOrder;
	}

	//		Method - createNewOrder - create an empty order with no items
	//			input - none
	//			output
	//				int	order number of the order just created
	int createNewOrder() {
		
		int orderNumber = nextOrder;
		orders.put(orderNumber, new ArrayList<>());	
		++nextOrder;
		return orderNumber;
	}

	//		Method - addToOrder - add a book to the order
	//			input
	//				order number the the book is supposed to be added to
	//				isbn number for the book being added
	//				shipping option how the book is supposed to be shipped
	//			Output
	//				boolean true if ass is successful, false if it fails
	 boolean addToOrder(Integer orderNumber, String iSBN, ShippingOption shippingOption) throws BookNotAvailableException {
		 
		 boolean returnValue = false;
		 
		 BookItem book = books.findBook(iSBN);		//	look up the book in the book catalogue 
		 
		 
		 if(book != null){							//	if null, book was not found
			 
			 int inStock = 1;						//	default value for in stock switch is yes
			 
			 if(shippingOption != ShippingOption.DOWNLOAD){		//	downloadable material always in stock
				 
				 inStock = warehouse.retrieveAvailableQuantity(book);	//	check if item is in stock
			 }
			 
			 if(inStock == 1) {									//	if instock build order item
				 
				 double salesTaxPercent = salesTax.getStateSalesTaxRate(book.getZipCode());
				 
				 double shipping = shippingOption.getShippingIncrement();
				 
				 double baseCost = book.getCost();

				 double bookTotal = baseCost + (baseCost * shipping) + (baseCost * salesTaxPercent);
				 
				 List<Order> list = orders.get(orderNumber);

				 list.add(new Order(book.getISBN(), shippingOption, book.getZipCode(), baseCost, salesTaxPercent, bookTotal));
				 
				 orders.replace(orderNumber, list);
				 
				 returnValue = true;
				 
			 }
		 } else {
			 returnValue = false;
		 }
		 
		return returnValue;
	}
	 
	//		method - listOrder - list the items in an order
	//			input
	//				int order number to be listed
	//			output
	//				String containing all info for order items
	String listOrder(int orderNumber){
		
		 List<Order> list = orders.get(orderNumber);
		 
		 StringBuilder sb = new StringBuilder();

		 for (Order order : list) {
			sb.append(order);
		 }
		 
		 return sb.toString();
		 
	}
	
	//		Method	-	orderTotal - sum the items in an order
	//			input
	//				int  order number to be totaled
	//			output
	//				double - sum of order item costs
	double orderTotal(int orderNumber){
		
		double orderTotal = 0.00;
		List<Order> list = orders.get(orderNumber);
		
		for (Order order : list) {
			orderTotal += order.getBookTotal();
		 }
		
		return orderTotal;	

	}
	
	//		Method - orderSize - return the number of items in this order
	//			input
	//				int	-	order number to get the size from
	//			output
	//				integer - size of list
	int orderSize(int orderNumber){
		List<Order> list = orders.get(orderNumber);
		return list.size();
	}

}
