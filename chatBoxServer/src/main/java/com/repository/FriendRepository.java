package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

	List<Friend> findByMyCustomer(Long myCustomer);
	
	Friend findByMyCustomerAndFriendWith(Long your,Long myFriend);
	Friend findByMyCustomerOrFriendWith(Long your,Long myFriend);
}
