package com.whowritesblog.service;

import com.whowritesblog.dto.RegisterUserDto;
import com.whowritesblog.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserService {
    void createUser(RegisterUserDto clientDto);
    void deleteUserById(Integer id);
    RegisterUserDto updateUserInfo(RegisterUserDto clientDto);
    List<User> findAll();
    RegisterUserDto findUserById(Integer id);
}
