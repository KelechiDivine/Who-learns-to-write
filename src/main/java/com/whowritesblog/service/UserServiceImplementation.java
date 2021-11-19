package com.whowritesblog.service;

import com.whowritesblog.dto.RegisterUserDto;
import com.whowritesblog.model.User;
import com.whowritesblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository repository;
    @Override
    public void createUser(RegisterUserDto clientDto) {
        User user = new User();
        user.setLastname(clientDto.getLastname());
        user.setFirstname(clientDto.getFirstname());
        user.setCountry(clientDto.getCountry());
        user.setDateOfBirth(clientDto.getDateOfBirth());
        user.setPhoneNumber(clientDto.getPhoneNumber());
        user.setId(9);
        user.setIsVerified(true);

        repository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {

    }

    @Override
    public RegisterUserDto updateUserInfo(RegisterUserDto clientDto) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public RegisterUserDto findUserById(Integer id) {
        return null;
    }
}
