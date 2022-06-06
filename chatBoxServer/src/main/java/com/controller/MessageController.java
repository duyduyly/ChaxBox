//package com.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.entity.BoxChat;
//import com.entity.Customer;
//import com.entity.Friend;
//import com.entity.Users;
//import com.form.countMessageUnSeen;
//import com.service.IAccountService;
//import com.service.IBoxChatService;
//import com.service.ICustomerService;
//import com.service.IFriendService;
//import com.service.IMessageService;
//import com.util.SessionService;
//
//@RestController
//@RequestMapping("api/")
//public class MessageController {
//
//	@Autowired
//	private IFriendService friendService;
//
//	@Autowired
//	private IAccountService accountService;
//
//	@Autowired
//	private IMessageService messageService;
//
//	@Autowired
//	private IBoxChatService boxChatService;
//
//	@Autowired
//	private ICustomerService customerService;
//
//	@Autowired
//	SessionService sessionService;
//	
//	@GetMapping("count-MessageUnseen")
//	public countMessageUnSeen countMessageUnseen() {
//		
//		Users userSession = sessionService.get(contant.USER_SESSION);
//		Users user = accountService.findById(userSession.getId());
//
//		List<Friend> friendList = friendService.findAllFiendByAccount(user);
//
//		List<Customer> customerList = new ArrayList<>();
//		for (Friend friend : friendList) {
//			Customer customer = customerService.findById(friend.getFriendWith());
//			customerList.add(customer);
//		}
//
//		List<BoxChat> boxChatList = null;
//
//		
////		try {
//
////			if (this.checkExistMessage(messageService.findByFromAndTo(userSession.getId(), id)) == true) {
////				boxChatList = boxChatService.findByMessage(messageService.findByFromAndTo(userSession.getId(), id));
////			} else {
////				boxChatList = boxChatService.findByMessage(messageService.findByFromAndTo(id, userSession.getId()));
////			}
////		} catch (Exception e) {
////			System.out.println(e.getMessage());
////			boxChatList = boxChatService.findByMessage(messageService.findByFromAndTo(id, userSession.getId()));
////		}
//		
//		return null;
//	}
//	
//}
