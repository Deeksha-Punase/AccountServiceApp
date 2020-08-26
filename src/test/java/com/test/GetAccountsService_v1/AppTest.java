package com.test.GetAccountsService_v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.GetAccountService_v1.util.AccountDto;
import com.test.GetAccountsService_v1.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest{
 
	@Autowired
	AccountService service;
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
    public void getCustomerSuccess() throws Exception
    {
		
		AccountDto acc1 = new AccountDto();
		acc1.setAccountId(1);
		acc1.setAccountNum("Test1");
		acc1.setAccountType("Savings");
		acc1.setBalance(100.0);
		acc1.setIsActive(true);
	 		
	    MvcResult result = mockMvc.perform(get("http://localhost:8080/account/customer/{id}","1")).andReturn();
	        		
	    ObjectMapper mapper = new ObjectMapper();

	    AccountDto accResponse = mapper.readValue(result.getResponse().getContentAsByteArray(), AccountDto.class);
	    assertEquals(acc1,accResponse);
    }
	
	@Test
    public void getCustomerNotExist() throws Exception
    {
	
	    MvcResult result = mockMvc.perform(get("http://localhost:8080/account/customer/{id}","5")).andReturn();

	    AccountDto accResponse = mapper.readValue(result.getResponse().getContentAsByteArray(), AccountDto.class);
	    assertEquals("User Doesn't Exist",accResponse.getMsg());
    }
	
	@Test
    public void getCustomerActive() throws Exception
    {
	
	    MvcResult result = mockMvc.perform(get("http://localhost:8080/account/customer/activeCheck")).andReturn();
	    assertNotNull(result.getResponse());
    }
}
