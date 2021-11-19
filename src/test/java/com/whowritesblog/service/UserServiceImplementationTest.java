package com.whowritesblog.service;

import com.whowritesblog.dto.RegisterUserDto;
import com.whowritesblog.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplementationTest {

    @Autowired
    UserService service;

    @BeforeEach
    void setUp() {
//        service = new UserServiceImplementation();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void createUser() {
        RegisterUserDto dto = new RegisterUserDto();
        dto.setFirstname("Onyimo");
        dto.setLastname("Favy");
        dto.setCountry("Nigeria");
        dto.setDateOfBirth("5/5/33");
        dto.setPhoneNumber("111111");
        dto.setIsVerified(true);
        service.createUser(dto);
        assertNotNull(service.findAll());
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void updateUserInfo() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findUserById() {
    }
}