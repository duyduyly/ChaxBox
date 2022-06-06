package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Customer;
import com.entity.Users;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByAccount(Users user);
}
