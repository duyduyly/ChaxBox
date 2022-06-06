package com.service;

import java.util.List;

import com.entity.BoxChat;
import com.entity.Message;

public interface IBoxChatService {

	List<BoxChat> findByMessage(Message messageId);
	BoxChat save(BoxChat boxChat);
}
