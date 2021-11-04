package com.whowritesblog.service;

import com.whowritesblog.exception.ClientException;
import com.whowritesblog.model.Client;
import com.whowritesblog.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@Slf4j
@SpringBootTest
//@RunWith(SpringRunner.class)

public class ClientServiceImplementationTest {
	
	@Mock
	private ClientRepository clientRepository;
	
	@InjectMocks
	private  ClientServiceImplementation clientServiceImplementation;
	
	@Autowired
	private  ClientServiceImplementation getClientServiceImplementation;
	
	MockHttpServletRequest request = new MockHttpServletRequest();
	
	private Client client;
	
	@BeforeEach
	public void setClientServiceImplementation() {
		client = new Client();
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void test_createClientAccount() throws ClientException {
	
		client.setAccountCreationDate(LocalDate.now());
		client.setLastname("Okoroafor");
		client.setFirstname("Kelechi");
		client.setAge(19);
		client.setAddress("null");
		client.setCountry("UAR");
		client.setEmail("Okoroaforkelechi123@gmail.com");
		client.setDateOfBirth("16/12/2002");
		client.setIsVerified(false);
		client.setPhoneNumber("09087747392");
		
		clientServiceImplementation.registerClient(client);
		
		log.info("Created a dummy client --> {}", client);
	}
}