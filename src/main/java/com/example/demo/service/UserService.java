package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User add(User user);

    List<User> getAllUsers();

    User findById(Long id);

    void update(User user);

    void delete(Long id);
}
