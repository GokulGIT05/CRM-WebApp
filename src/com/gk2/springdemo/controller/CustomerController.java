package com.gk2.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gk3.springdemo.service.CustomerService;
import com.gk5.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// DI: Spring will scan for the Implemented class for CustomerDAO,
	// in here we have only one implementation so no need of qualifier. 
	// There are two types of autowired, byType & byName.
	@Autowired
	private CustomerService customers;

	@GetMapping("/list")
	public String getCustomer(Model theModelContainer) {

		List<Customer> customerList = customers.getCustomers();

		theModelContainer.addAttribute("customers", customerList);
		
		return "list-customers";
	}

	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModelContainer) {
		
		Customer customer = new Customer();
		theModelContainer.addAttribute("customer",customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer ) {
		
		customers.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@ModelAttribute("customerId") int id,Model theModelContainer ) {
		
		Customer customer = customers.getCustomers(id); 
		theModelContainer.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	
	@GetMapping("/delete")
	public String delete(@ModelAttribute("customerId") int id) {
		
		customers.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
}
