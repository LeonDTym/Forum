package com.twopythons.forum.model.service;

import com.twopythons.forum.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);
    void changeUser(User user);
    void deleteUserById(Long id);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
}
