package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Customer;
import com.entity.Friend;
import com.entity.Users;
import com.service.IAccountService;
import com.service.ICustomerService;
import com.service.IFriendService;
import com.util.SessionService;

@RestController
@RequestMapping("api/")
public class FriendController {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IFriendService friendService;

	@Autowired
	private IAccountService accountService;

	@Autowired
	SessionService sessionService;

	@GetMapping("/friendList")
	public List<Customer> customerList() {
		Users userSession = sessionService.get(contant.USER_SESSION);
		Users user = accountService.findById(userSession.getId());
		Long customerId = customerService.findByAccount(user).getId();

		List<Friend> friendList = friendService.findAll();
		

		System.out.println(userSession.toString());

		List<Customer> listAllCustomer = customerService.findAll();

		List<Customer> customerList = new ArrayList<>();
		
		for (Friend friend : friendList) {
//			Customer customer = customerService.findById(friend.getFriendWith());
			if(customerId == friend.getFriendWith() || customerId == friend.getMyCustomer()) {
				if(customerId == friend.getFriendWith()) {
					Customer customer = customerService.findById(friend.getMyCustomer());
					customerList.add(customer);
				}else {
					Customer customer = customerService.findById(friend.getFriendWith());
					customerList.add(customer);
				}
			}
			
		}
		
		for (Customer customer : customerList) {
			listAllCustomer.removeIf(e -> (e.getId() == customer.getId()));
		}
		listAllCustomer.removeIf(e -> (e.getId() == customerId));

		return listAllCustomer;
	}

	@PostMapping("/makeFriend")
	public String makeFriend(@RequestBody Long CustomerFriendId) {
		Users userSession = sessionService.get(contant.USER_SESSION);
		Users user = accountService.findById(userSession.getId());
		Long myCustomerId = accountService.findById(userSession.getId()).getId();
		
		String message = "";

		if (friendService.findByMyCustomerAndFriendWith(myCustomerId, CustomerFriendId) != null) {
			message = "Fail";
			System.err.println("if");
		} else if (friendService.findByMyCustomerAndFriendWith(CustomerFriendId, myCustomerId) != null) {
			message = "Fail";
			System.err.println("else if");
		} else {
			Friend friend = new Friend(null, myCustomerId, CustomerFriendId);
			friendService.save(friend);
			message = "Success";
		}
		System.out.println(message);
		System.out.println(friendService.findByMyCustomerAndFriendWith(1l, 2l));

		return message;
	}
}
