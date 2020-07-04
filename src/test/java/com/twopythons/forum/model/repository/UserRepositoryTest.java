package com.twopythons.forum.model.repository;

import com.twopythons.forum.ForumApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAllIsNotEmpty() {
        Assert.assertFalse(userRepository.findAll().isEmpty());
    }

    @Test
    public void testRoleOfUserIsAdmin() {
        Assert.assertEquals("Admin", userRepository.findById(1L).get().getRole().name());
    }
}
