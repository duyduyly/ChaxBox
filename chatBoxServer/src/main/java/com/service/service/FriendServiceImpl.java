package com.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Friend;
import com.entity.Users;
import com.repository.CustomerRepository;
import com.repository.FriendRepository;
import com.service.IFriendService;

@Service
public class FriendServiceImpl implements IFriendService {

	@Autowired
	FriendRepository friendRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Friend> findAllFiendByAccount(Users user) {
		Long id =  customerRepository.findByAccount(user).getId();
		return friendRepository.findByMyCustomer(id);
	}

	@Override
	public Friend save(Friend friend) {
		return friendRepository.save(friend);
	}

	@Override
	public Friend findByMyCustomerAndFriendWith(Long your, Long myFriend) {
		return friendRepository.findByMyCustomerAndFriendWith(your, myFriend);
	}

	@Override
	public Friend findByMyCustomerOrFriendWith(Long your, Long myFriend) {
		return friendRepository.findByMyCustomerOrFriendWith(your, myFriend);
	}

	@Override
	public List<Friend> findAll() {
		return friendRepository.findAll();
	}
}
