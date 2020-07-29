package com.youhubs.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	public List<Customer> listCustomer() {
		return (List<Customer>) repo.findAll();
	}
	
	public void save(Customer customer) {
		repo.save(customer);
	}
	
	
}
