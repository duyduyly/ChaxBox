package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.BoxChat;
import com.entity.Message;

@Repository
public interface BoxChatRepository extends JpaRepository<BoxChat, Long> {

	List<BoxChat> findByMessage(Message messageId);
	
}
