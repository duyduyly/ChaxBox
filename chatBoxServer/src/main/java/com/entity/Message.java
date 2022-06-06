package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MESSAGE1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "from1")
	private long from;
	
	@Column(name = "to1")
	private long to;
	
	
//	@OneToMany(mappedBy="message",fetch = FetchType.LAZY)
//	private Set<BoxChat> boxChat;
	
}
