package com.example.demo.Dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getAllUsers();

    User findById(Long id);

    void update(User user);

    void delete(Long id);
}
