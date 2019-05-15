package com.grocery;

class Customer
{
	private String name;
	private Long phoneNumber;

	Customer(String name, Long phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	static void printCustomer(Customer customer)
	{
		System.out.println("customer name" + "\t" + "phone number");
		System.out.println(customer.name + "\t" + customer.phoneNumber);
	}
}
