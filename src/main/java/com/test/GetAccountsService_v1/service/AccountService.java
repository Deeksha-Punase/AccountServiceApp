package com.test.GetAccountsService_v1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.GetAccountService_v1.util.AccountDto;
import com.test.GetAccountsService_v1.domain.AccountDomain;
import com.test.GetAccountsService_v1.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository repository;
	
	
	public AccountDto getByAccountId(Integer id){
		
		AccountDomain account = repository.findByAccountId(id);
		if(null != account) {
			ModelMapper mapper = new ModelMapper();
			AccountDto accDto = mapper.map(account, AccountDto.class);
			return accDto;
		}
		else return new AccountDto("User Doesn't Exist");
	}
	
	public String addCustomerDetails(List<AccountDto> body) {
		
		ModelMapper modelMapper = new ModelMapper();
		try {
			body.stream().forEach(data -> {
				AccountDomain accDto = modelMapper.map(data, AccountDomain.class);
				repository.saveAndFlush(accDto);
			});
			return "Account Info added";
		}catch(Exception e) {
			return "Exception occurred while adding account info";
		}
		
	}

	public List<AccountDto> getByActiveAccount() {
		
		List<AccountDomain> account = repository.findAll();
		
		ModelMapper modelMapper = new ModelMapper();
		List<AccountDto> activeList = account.stream().filter(AccountDomain::getIsActive)
				.map(data -> modelMapper.map(data, AccountDto.class)).collect(Collectors.toList());
		return activeList;
		
		
	}
}
