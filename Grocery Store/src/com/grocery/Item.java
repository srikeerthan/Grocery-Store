package com.grocery;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class Item
{
	String name;
	String code;
	BigDecimal price;
	BigDecimal discount;
	int stock;
	String category;
	private static List<Item> itemsList;

	Item(String name, String code, BigDecimal price, int stock, String category)
	{
		this.name = name;
		this.code = code;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}

	static void init()
	{
		Item goodDay = new Item("goodDay biscuit", "gdb", new BigDecimal(10.0), 10, "biscuits");
		Item bourbon = new Item("bourbon biscuit", "bbb", new BigDecimal(15.0), 5, "biscuits");
		Item tiger = new Item("tiger biscuit", "tgb", new BigDecimal(5.0), 15, "biscuits");
		itemsList = new ArrayList<>();
		itemsList.add(goodDay);
		itemsList.add(bourbon);
		itemsList.add(tiger);
	}

	static void displayStock()
	{
		System.out.println("name" + "\t" + "code" + "\t" + "price" + "\t" + "stock");
		printItems(itemsList, true);
	}

	static Item validateAndGetItem(String code, int quantity) throws Exception
	{
		for(Item item : itemsList)
		{
			if(item.code.equals(code))
			{
				if(item.stock - quantity < 0)
				{
					throw new Exception("Please Enter the valid quantity");
				}
				return item;
			}
		}

		throw new Exception("Please Enter the correct Item code");
	}

	static void decrementItemsStock(String itemCode, int quantity)
	{
		for(Item item: itemsList)
		{
			if(item.code.equals(itemCode))
			{
				item.stock = item.stock - quantity;
			}
		}
	}

	static void printItems(List<Item> items, boolean isStockDisplay)
	{
		System.out.println("name" + "\t" + "code" + "\t" + "price" + "\t" + "stock");
		for(Item item : items)
		{
			if(!(isStockDisplay && item.stock <= 0))
			{
				System.out.println(item.name + "\t" + item.code + "\t" + item.price + "\t" + item.stock);
			}
		}
	}
}
