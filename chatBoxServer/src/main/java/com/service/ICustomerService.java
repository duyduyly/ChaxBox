package com.service;

import java.util.List;

import com.entity.Customer;
import com.entity.Users;

public interface ICustomerService {
	
	Customer findByAccount(Users user);
	Customer findById(Long id);
	Customer save(Customer customer);
	List<Customer> findAll();
}
