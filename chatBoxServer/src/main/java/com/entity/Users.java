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
@Table(name = "USERS2")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "us",columnDefinition = "varchar(300)")
	private String username;

	
	private String password;
	
//	@OneToOne(mappedBy = "account")
//	private Customer customer;
	
}
