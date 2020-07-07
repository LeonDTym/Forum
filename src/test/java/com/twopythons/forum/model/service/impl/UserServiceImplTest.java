package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.ForumApplication;
import com.twopythons.forum.model.entity.User;
import com.twopythons.forum.model.entity.enums.Role;
import com.twopythons.forum.model.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void createUserWithExistId() {

        User user = new User();
        user.setId(1L);
        user.setEmail("1985-589@gmail.com");
        user.setLogin("1985");
        user.setPassword("12345678");
        user.setRole(Role.User);
        userService.createUser(user);

    }
}