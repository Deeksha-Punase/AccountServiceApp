package com.test.GetAccountsService_v1.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Accounts")
@Data
public class AccountDomain implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name ="Account_Id")
	Integer accountId;
	
	@Column(name ="Account_Number")
	String accountNum;
	
	@Column(name ="Account_Type")
	String accountType;
	
	@Column(name ="IsActive")
	Boolean isActive;
	
	@Column(name="Balance")
	Double balance;
}
