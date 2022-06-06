package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	Message findByFromAndTo(long from,long to);
	
	
}
