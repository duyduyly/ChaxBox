package com.service;

import com.entity.Users;

public interface IAccountService {
	
	Users FindByUsername(String account);
	
	Users findById(Long id);
	
	Users findByUsername(String username);
	
	Users save(Users user);
}
