package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.User;
import com.twopythons.forum.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceCommonImpl<User, UserRepository> {

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    public void update(User user) {
        repository.save(user);
    }

//TODO update user ban methods

//    @Transactional
//    public void changeRole(Long id, Role newRole) {
//
//    }
//
//    @Transactional
//    public void banById(Long id) {
//        getById(id).ifPresent(user -> user.setIsBanned(true));
//    }
//
//    @Transactional
//    public void unbanById(Long id) {
//        getById(id).ifPresent(user -> user.setIsBanned(false));
//    }

}
