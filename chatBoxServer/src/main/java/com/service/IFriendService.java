package com.service;

import java.util.List;

import com.entity.Friend;
import com.entity.Users;

public interface IFriendService {

	List<Friend> findAllFiendByAccount(Users user);
	
	Friend save(Friend friend);
	
	Friend findByMyCustomerAndFriendWith(Long your,Long myFriend);
	
	Friend findByMyCustomerOrFriendWith(Long your,Long myFriend);
	
	List<Friend> findAll();
}
