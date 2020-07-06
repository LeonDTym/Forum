package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.User;
import com.twopythons.forum.model.repository.UserRepository;
import com.twopythons.forum.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void changeUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        getUserById(id).ifPresent(user -> userRepository.delete(user));
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
