package com.br.HairForce.backendHairForce.service;

import com.br.HairForce.backendHairForce.controller.CreateUserDto;
import com.br.HairForce.backendHairForce.entity.User;
import com.br.HairForce.backendHairForce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long createUser(CreateUserDto createUserDto){
        // DTO -> ENTITY

        User user = new User ();

        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());

        userRepository.save(user);
        return user.getUserId();
    }

}
