package com.test.GetAccountService_v1.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class AccountDto {

	private Integer accountId;

	private String accountNum;

	private String accountType;

	private Boolean isActive;

	private Double balance;
	
	private String msg;

	public AccountDto(String msg) {
		this.msg=msg;
	}

	public AccountDto() {}
}
