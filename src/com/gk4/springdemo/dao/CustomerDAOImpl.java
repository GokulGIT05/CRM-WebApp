package com.gk4.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gk5.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// Step 1: Get the Current Session for the query.
		Session session = sessionFactory.getCurrentSession();
		
		// Step 2: Write the Query.
		Query<Customer> theQuery = session.createQuery("from Customer order by firstName",Customer.class);
		
		// Step 3: Execute the Query and Get the Customers from the DB
		List<Customer> customers = theQuery.getResultList();
		
		// Step 4 Return the Customers.
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		// Step 1: Get the Current Session for the query.
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomers(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class,id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {

		Session session = sessionFactory.getCurrentSession();
		
		Query theQuery = session.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		theQuery.executeUpdate();
	}

}
