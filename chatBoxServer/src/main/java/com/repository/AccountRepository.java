package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Users;

@Repository
public interface AccountRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String account);
	
}
