package com.sreyes.services;

import org.springframework.stereotype.Service;

import com.sreyes.model.UserEntity;

@Service
public interface UserService {
    void save(UserEntity user);

    UserEntity findByUsername(String username);
}