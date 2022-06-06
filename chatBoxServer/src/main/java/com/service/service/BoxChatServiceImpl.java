package com.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.BoxChat;
import com.entity.Message;
import com.repository.BoxChatRepository;
import com.service.IBoxChatService;

@Service
public class BoxChatServiceImpl implements IBoxChatService {
	@Autowired
	BoxChatRepository boxChatRepository;

	@Override
	public List<BoxChat> findByMessage(Message messageId) {
		return boxChatRepository.findByMessage(messageId);
	}

	@Override
	public BoxChat save(BoxChat boxChat) {
		return boxChatRepository.save(boxChat);
	}

}
