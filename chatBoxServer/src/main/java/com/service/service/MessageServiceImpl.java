package com.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Message;
import com.repository.MessageRepository;
import com.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {
	@Autowired
	MessageRepository messageRepository;

	@Override
	public Message findByFromAndTo(long from, long to) {
		// TODO Auto-generated method stub
		return messageRepository.findByFromAndTo(from, to);
	}

	@Override
	public Message save(Message message) {
		
		return messageRepository.save(message);
	}
}
