package com.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Users;
import com.repository.AccountRepository;
import com.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Users FindByUsername(String account) {
		return accountRepository.findByUsername(account);
	}

	@Override
	public Users findById(Long id) {
		return accountRepository.findById(id).get();
	}

	@Override
	public Users findByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

	@Override
	public Users save(Users user) {
		
		return accountRepository.save(user);
	}

}
