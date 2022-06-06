package com.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Customer;
import com.entity.Users;
import com.repository.CustomerRepository;
import com.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer findByAccount(Users user) {
		return customerRepository.findByAccount(user);
	}

	@Override
	public Customer findById(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
}
