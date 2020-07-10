package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.ForumApplication;
import com.twopythons.forum.model.entity.User;
import com.twopythons.forum.model.entity.enums.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void update() {

        userService.getById(1L).ifPresent(user -> {
            String newPassword = "87654321";
            String newLogin = "whatislove";
            user.setPassword(newPassword);
            user.setLogin(newLogin);
            userService.update(user);
            Assert.assertEquals(newPassword, userService.getById(1L).orElse(new User()).getPassword());
            Assert.assertEquals(newLogin, userService.getById(1L).orElse(new User()).getLogin());
        });

    }

    @Test
    public void banUnbanById() {

        Boolean isBanned;

        userService.banById(1L);
        isBanned = userService.getById(1L).orElse(new User()).getIsBanned();

        Assert.assertEquals(true, isBanned);

        userService.unbanById(1L);
        isBanned = userService.getById(1L).orElse(new User()).getIsBanned();

        Assert.assertEquals(false, isBanned);

    }

    @Test
    public void changeRole() {

        Role newRole = Role.Admin;
        Long id = 1L;

        userService.changeRole(id, newRole);
        User user = userService.getById(id).orElse(new User());

        Assert.assertEquals(newRole, user.getRole());

    }

}