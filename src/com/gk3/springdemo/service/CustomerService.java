package com.gk3.springdemo.service;

import java.util.List;

import com.gk5.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomers(int id);

	public void deleteCustomer(int id);
}
