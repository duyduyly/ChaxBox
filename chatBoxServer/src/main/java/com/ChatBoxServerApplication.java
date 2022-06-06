package com;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.BoxChat;
import com.entity.Customer;
import com.entity.Friend;
import com.entity.Message;
import com.entity.Users;
import com.repository.AccountRepository;
import com.repository.BoxChatRepository;
import com.repository.CustomerRepository;
import com.repository.FriendRepository;
import com.repository.MessageRepository;

@SpringBootApplication
public class ChatBoxServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChatBoxServerApplication.class, args);
	}

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired 
	CustomerRepository customerRepository;
	
	@Autowired 
	MessageRepository messageRepository;
	
	@Autowired
	FriendRepository friendRepository;
	
	@Autowired
	BoxChatRepository boxChatRepository;
	
	@Override
	public void run(String... args) throws Exception {
	 
		accountRepository.save(new Users(null,"user01","123"));
		accountRepository.save(new Users(null,"user02","123"));
		accountRepository.save(new Users(null,"user03","123"));
		
		
		Users user01 = accountRepository.findById(1l).get();
		Users user02 = accountRepository.findById(2l).get();
		Users user03 = accountRepository.findById(3l).get();
		customerRepository.save(new Customer(0, "User01", "User01", user01));
		customerRepository.save(new Customer(0, "User02", "User02", user02));
		customerRepository.save(new Customer(0, "User03", "User03", user03));
		
		
		
		Message message1 = new Message(0l, 1l, 2l);
		Message message2 = new Message(0l, 2l, 3l);
//		message1.setBoxChat(setBoxChat1);
//		message2.setBoxChat(setBoxChat2);
		
		Message mes1 = messageRepository.save(message1);
		Message mes2 = messageRepository.save(message2);
		

//		Set<BoxChat> setBoxChat1 = new HashSet<BoxChat>();
//		Set<BoxChat> setBoxChat2 = new HashSet<BoxChat>();
		
		
		
		
		
		BoxChat boxchat1 = new BoxChat(0l, "hello user02", new Date(), true, 1l, mes1);
		BoxChat boxchat2 = new BoxChat(0l, "hi user01", new Date(), true, 2l, mes1);
		BoxChat boxchat3 = new BoxChat(0l, "How are you?", new Date(), true, 1l, mes1);
		BoxChat boxchat4 = new BoxChat(0l, "Not bad not bad,me too.", new Date(), true, 2l, mes1);
		
		
		BoxChat boxchat5 = new BoxChat(0l, "hello user03", new Date(), true, 2l, mes2);
		BoxChat boxchat6 = new BoxChat(0l, "hi user02", new Date(), true, 3l, mes2);
		
		
		
//		setBoxChat1.add(boxchat1);
//		setBoxChat1.add(boxchat2);
//		setBoxChat1.add(boxchat3);
//		setBoxChat1.add(boxchat4);
//		
//		setBoxChat2.add(boxchat5);
//		setBoxChat2.add(boxchat6);
		
	
			boxChatRepository.save(boxchat1);
			boxChatRepository.save(boxchat2);
			boxChatRepository.save(boxchat3);
			boxChatRepository.save(boxchat4);
			boxChatRepository.save(boxchat5);
			boxChatRepository.save(boxchat6);
		
	
		
		friendRepository.save(new Friend(null,1l,2l));
		friendRepository.save(new Friend(null,2l,1l));
		friendRepository.save(new Friend(null,2l,3l));
		friendRepository.save(new Friend(null,3l,1l));
		
	}

}
