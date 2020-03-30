package com.gk3.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gk4.springdemo.dao.CustomerDAO;
import com.gk5.springdemo.entity.Customer;

@Service
public class CustomerSericeImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;
	
	@Override
	@Transactional // Service layer will handle all the transactional flows.
	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomers(int id) {
		return customerDao.getCustomers(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
		
	}

}
