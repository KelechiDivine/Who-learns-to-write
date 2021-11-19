package com.whowritesblog.repository;

import com.whowritesblog.model.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@Slf4j

public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	private User client;
	
	@BeforeEach
	public void setClient(){
		client = new User();
	}
	
	@Test
	public void shouldFindNoClientIfModelDoesNotExist(){
		User clientModel = new User();
		Assertions.assertThat(clientModel).isNotNull();
		log.info("User model is not null --> {}", clientModel);
	}
	
	@Test
	public void test_createClient(){
		
		client.setFirstname("Iclass");
		client.setLastname("Chima");
		client.setCountry("Nigeria");
		client.setPhoneNumber("08024002434");
		client.setDateOfBirth("April 1");
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
		
		userRepository.save(client);
		
		log.info("Successfully created client with phone number --> {}", client.getPhoneNumber());
	}
	
	@Test
	public void test_findClientById(){
		client = userRepository.findById(8).orElse(null);
		Assertions.assertThat(client).isNotNull();
		log.info("Found client in database --> {}", client.getId());
		log.info("Found client by first name --> {}", client.getFirstname());
	}
}