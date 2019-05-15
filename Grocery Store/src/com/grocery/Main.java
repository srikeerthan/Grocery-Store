package com.grocery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Main
{

	public static void main(String[] args) throws Exception
	{
		Item.init();
		Item.displayStock();
		System.out.println("enter the number of items required");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Item> items = new ArrayList<>();
		System.out.println("enter item code and quantity of items");
		for(int i = 0; i < n; i++)
		{
			String itemCode = sc.next();
			int quantity = sc.nextInt();
			if(quantity <= 0)
			{
				throw new Exception("Invalid value passed for item quantity");
			}
			Item item = Item.validateAndGetItem(itemCode, quantity);
			items.add(new Item(item.name, itemCode, item.price, quantity, item.category));
		}
		System.out.println("enter the customer name and phone number");
		String customerName = sc.next();
		if(StringUtils.isEmpty(customerName))
		{
			throw new Exception("kindly enter the customer name");
		}
		Long phoneNumber = sc.nextLong();
		Customer customer = new Customer(customerName, phoneNumber);
		Sales.createSale(customer, items);
		Item.displayStock();
		Sales.getTotalSales();
	}
}
