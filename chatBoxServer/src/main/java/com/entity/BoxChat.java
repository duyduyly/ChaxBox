package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "BOXCHAT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoxChat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "messageText")
	private String messageText;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createMessage;
	
	@Column(name = "status")
	private boolean status;
	
	private long idSender;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="message_Id", nullable=false)
	private Message message;
}
