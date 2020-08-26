package com.test.GetAccountsService_v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.GetAccountService_v1.util.AccountDto;
import com.test.GetAccountsService_v1.domain.AccountDomain;
import com.test.GetAccountsService_v1.service.AccountService;

@RestController
@RequestMapping(value="account/")
public class AccountController {

	@Autowired
	AccountService service;
	
	@PostMapping("customerDetails/add")
	public String  addCustomerDetails(@RequestBody List<AccountDto> body){
		
		String message  = service.addCustomerDetails(body);
		return message;
		
	}
	
	@GetMapping("customer/{id}")
	public AccountDto getCustomerDetails(@PathVariable(value="id") Integer customerId){
		
		return service.getByAccountId(customerId);
		
	}
	/*
	 * API to get active accounts
	 * */
	@GetMapping("customer/activeCheck")
	public List<AccountDto> getCustomerActive(){
		
		return service.getByActiveAccount();
		
	}
}
