package com.grocery;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Sales
{
	private Customer customer;
	private List<Item> items;
	private BigDecimal total;
	private BigDecimal discountTotal;
	private static List<Sales> salesList = new ArrayList<>();

	private Sales(Customer customer, List<Item> items)
	{
		this.customer =customer;
		this.items =items;
	}

	static void createSale(Customer customer, List<Item> items)
	{
		Sales sale = new Sales(customer, items);
		sale.total = new BigDecimal(0);
		salesList.add(sale);
		for(Item item: items)
		{
			Item.decrementItemsStock(item.code, item.stock);
			sale.total = sale.total.add(item.price.multiply(new BigDecimal(item.stock)));
		}
	}

	static void getTotalSales()
	{
		for(Sales sale: salesList)
		{
			Customer.printCustomer(sale.customer);
			Item.printItems(sale.items, false);
			System.out.println("Total amount is: " + sale.total);
		}
	}
}
