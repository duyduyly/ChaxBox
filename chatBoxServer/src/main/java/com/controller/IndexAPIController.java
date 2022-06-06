package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.BoxChat;
import com.entity.Customer;
import com.entity.Friend;
import com.entity.Message;
import com.entity.Users;
import com.repository.AccountRepository;
import com.repository.BoxChatRepository;
import com.repository.CustomerRepository;
import com.repository.MessageRepository;
import com.service.IAccountService;
import com.service.IBoxChatService;
import com.service.ICustomerService;
import com.service.IFriendService;
import com.service.IMessageService;
import com.service.service.AccountServiceImpl;
import com.service.service.FriendServiceImpl;
import com.util.SessionService;

@RestController
@RequestMapping("api/")
public class IndexAPIController {

	@Autowired
	private IFriendService friendService;

	@Autowired
	private IAccountService accountService;

	@Autowired
	private IMessageService messageService;

	@Autowired
	private IBoxChatService boxChatService;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	SessionService sessionService;

	public IndexAPIController() {

	}

	// select friend đã kết bạn
	@GetMapping("list-Friend")
	public List<Customer> listFriend() {

		Users userSession = sessionService.get(contant.USER_SESSION);
		Users user = accountService.findById(userSession.getId());
		Long customerId = customerService.findByAccount(user).getId();

		List<Friend> friendList = friendService.findAll();
		
		List<Customer> customerList = new ArrayList<>();
		Set<Customer> setCustomer = new HashSet<Customer>();
		
		for (Friend friend : friendList) {
			if(customerId == friend.getFriendWith() || customerId == friend.getMyCustomer()) {
				if(customerId == friend.getFriendWith()) {
					Customer customer = customerService.findById(friend.getMyCustomer());
					setCustomer.add(customer);
				}else if(customerId == friend.getMyCustomer()) {
					Customer customer = customerService.findById(friend.getFriendWith());
					setCustomer.add(customer);
				}
			}
			
		}
		
		//gán set in list Customer
		customerList.addAll(setCustomer);

		return customerList;
	}

	// select All Message by myFriend
	@GetMapping("listMy-Message")
	public List<BoxChat> listMessage(@RequestParam Long id) {
		Users userSession = sessionService.get(contant.USER_SESSION);

		// set session myFriend ID;
		sessionService.set(contant.FRIEND_SESSION, id);

		System.err.println("MyFriend Id: " + id);
		List<BoxChat> boxChatList = null;

		try {

			if (this.checkExistMessage(messageService.findByFromAndTo(userSession.getId(), id)) == true) {
				boxChatList = boxChatService.findByMessage(messageService.findByFromAndTo(userSession.getId(), id));
			} else {
				boxChatList = boxChatService.findByMessage(messageService.findByFromAndTo(id, userSession.getId()));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			boxChatList = boxChatService.findByMessage(messageService.findByFromAndTo(id, userSession.getId()));
		}

		return boxChatList;

	}

	// send from myUser to MyFriend
	@PostMapping("Send-Message")
	public List<BoxChat> sendMessage(@RequestBody String message) {

		Users userSession = sessionService.get(contant.USER_SESSION);
		Long FriendId = sessionService.get(contant.FRIEND_SESSION);

		System.err.println("Myfriend send Id: " + FriendId);

		List<BoxChat> boxChatList = null;
		try {

			if (this.checkExistMessage(messageService.findByFromAndTo(userSession.getId(), FriendId)) == true) {
				// update date thêm message chỗ case đó
				Message message1 = messageService.findByFromAndTo(userSession.getId(), FriendId);
				BoxChat boxchat1 = new BoxChat(0l, message, new Date(), false, userSession.getId(), message1);
				boxChatService.save(boxchat1);
				boxChatList = boxChatService
						.findByMessage(messageService.findByFromAndTo(userSession.getId(), FriendId));

				System.out.println("Update Success");

			} else if (this.checkExistMessage(messageService.findByFromAndTo(FriendId, userSession.getId())) == true) {

				Message message1 = messageService.findByFromAndTo(FriendId, userSession.getId());
				BoxChat boxchat1 = new BoxChat(0l, message, new Date(), false, userSession.getId(), message1);
				boxChatService.save(boxchat1);
				boxChatList = boxChatService
						.findByMessage(messageService.findByFromAndTo(FriendId, userSession.getId()));

				System.out.println("Update Success");

			} else {
				// creat 1 message
				// create boxchat by message id
				// update date thêm message chỗ case đó
				Message message1 = new Message(0l, userSession.getId(), FriendId);
				Message mes1 = messageService.save(message1);
				BoxChat boxchat1 = new BoxChat(0l, message, new Date(), false, userSession.getId(), mes1);
				boxChatService.save(boxchat1);
				boxChatList = boxChatService
						.findByMessage(messageService.findByFromAndTo(userSession.getId(), FriendId));

				System.out.println("Create Success");
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			Message message1 = new Message(0l, userSession.getId(), FriendId);
			Message mes1 = messageService.save(message1);
			BoxChat boxchat1 = new BoxChat(0l, message, new Date(), false, userSession.getId(), mes1);
			boxChatService.save(boxchat1);
			boxChatList = boxChatService.findByMessage(messageService.findByFromAndTo(userSession.getId(), FriendId));

			System.out.println("Create Success");
		}

		return boxChatList;
	}

	@GetMapping("myCustomer")
	public Customer customerLogin() {

		return sessionService.get(contant.CUSTOMER_SESSION);
	}

	/**
	 * check message
	 * 
	 * @param message
	 * @return true if exist else false not exist
	 */
	public boolean checkExistMessage(Message mess) {
		if (mess == null) {
			System.out.println("Không có message");
			return false;
		} else {
			System.out.println(" có message");
			return true;
		}
	}

	public boolean checkSendTo() {

		return true;
	}

	public int countMessageSeen(Long From, Long To) {
		Message message = null;
		try {

			if (this.checkExistMessage(messageService.findByFromAndTo(From, To)) == true) {
				message = messageService.findByFromAndTo(From, To);

			} else if (this.checkExistMessage(messageService.findByFromAndTo(To, From)) == true) {
				message = messageService.findByFromAndTo(To, From);
			} else {
				System.out.println("Tin nhắn không tồn tài");
			}
		} catch (NullPointerException e) {
			System.out.println("Tin nhắn không tồn tài");
		}

		List<BoxChat> boxChat = boxChatService.findByMessage(message);

		int unseenMessage = 0;
		for (BoxChat boxChat2 : boxChat) {
			if (boxChat2.isStatus() == false) {
				unseenMessage++;
			}
		}

		if (unseenMessage == 0) {
			return 0;
		}
		return unseenMessage;
	}

}
