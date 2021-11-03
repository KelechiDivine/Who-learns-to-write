package com.whowritesblog.repository;

import com.whowritesblog.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Slf4j

public class ClientRepositoryTest {

	@Autowired
	private ClientRepository clientRepository;

	private Client client;
	
	@BeforeEach
	public void setClient(){
		client = new Client();
	}
	
	@Test
	public void shouldFindNoClientIfModelDoesNotExist(){
		Client clientModel = new Client();
		Assertions.assertThat(clientModel).isNotNull();
		log.info("Client model is not null --> {}", clientModel);
	}
	
	@Test
	public void test_createClient(){
		
		client.setFirstname("Ozioma");
		client.setLastname("Okoroafor");
		client.setAddress("peaceLand estate");
		client.setCountry("Nigeria");
		client.setAccountCreationDate(LocalDate.now());
		client.setAge(23);
		client.setPhoneNumber("09099474849");
		client.setDateOfBirth("February 27");
		client.setEmail("oziomaOkoroafor@gmail.com");
		client.setIsVerified(false);
		
		Assertions.assertThat(client).isNotNull();
		
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("firstname", "Ozioma");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("lastname", "Okoroafor");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("address", "peaceLand estate");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("country", "Nigeria");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("accountCreationDate", LocalDate.now());
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("age", 23);
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("phoneNumber", "09099474849");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("dateOfBirth", "February 27");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("email", "oziomaOkoroafor@gmail.com");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("isVerified", false);

		clientRepository.save(client);

		log.info("Successfully created client with email --> {}", client.getEmail());
		log.info("Successfully created client with phone number --> {}", client.getPhoneNumber());
	}
	
	@Test
	public void test_findClientById(){
		client = clientRepository.findById(8).orElse(null);
		Assertions.assertThat(client).isNotNull();
		log.info("Found client in database --> {}", client.getId());
		log.info("Found client by first name --> {}", client.getFirstname());
		log.info("Found client by email --> {}", client.getEmail());
	}
	
	@Test
	public void test_findAllClient(){
		List<Client> clientRepositoryAll = clientRepository.findAll();
		Assertions.assertThat(clientRepositoryAll).isNotNull();
		log.info("Found all client in the database --> {}", clientRepository.findAll());
	}
	
	@Test
	public void test_deleteClientById(){
		client = clientRepository.findById(8).orElse(null);
		Assertions.assertThat(client).isNotNull();
		clientRepository.deleteById(8);
		log.info("Deleted client successfully --> {}", client.getId());
	}
	
	@Test
	public void test_updateClientById(){
		client = clientRepository.findById(9).orElse(null);
		Assertions.assertThat(client).isNotNull();
		
		client.setEmail("newClientUpdate@gmail.com");
		client.setLastname("new client");
		
		clientRepository.updateClient(client);
		log.info("Updated client successfully --> {}", client);
	}
}