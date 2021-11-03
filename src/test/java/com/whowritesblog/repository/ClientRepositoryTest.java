package com.whowritesblog.repository;

import com.whowritesblog.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


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
		
		client.setFirstname("Iclass");
		client.setLastname("Chima");
		client.setAddress("peaceLand estate");
		client.setCountry("Nigeria");
		client.setAccountCreationDate(LocalDate.now());
		client.setAge(23);
		client.setPhoneNumber("08024002434");
		client.setDateOfBirth("April 1");
		client.setEmail("iclassChima@gmail.com");
		client.setIsVerified(false);
		
		Assertions.assertThat(client).isNotNull();
		
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("firstname", "Iclass");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("lastname", "Chima");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("address", "peaceLand estate");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("country", "Nigeria");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("accountCreationDate", LocalDate.now());
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("age", 23);
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("phoneNumber", "08024002434");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("dateOfBirth", "April 1");
		Assertions.assertThat(client).hasFieldOrPropertyWithValue("email", "iclassChima@gmail.com");
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
}