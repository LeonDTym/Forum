package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.User;
import com.twopythons.forum.model.repository.UserRepository;

public class UserServiceImpl extends ServiceCommonImpl<User, UserRepository> {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
