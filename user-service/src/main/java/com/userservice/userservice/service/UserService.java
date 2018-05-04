package com.userservice.userservice.service;


import com.userservice.userservice.entity.User;

public interface UserService {

    User registerUser(User input);

    Iterable<User> findAll();

    User findById(Long id);
}
