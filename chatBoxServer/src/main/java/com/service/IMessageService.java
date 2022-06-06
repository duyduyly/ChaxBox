package com.service;

import com.entity.Message;

public interface IMessageService {

	Message findByFromAndTo(long from,long to);
	Message save(Message message);
}
