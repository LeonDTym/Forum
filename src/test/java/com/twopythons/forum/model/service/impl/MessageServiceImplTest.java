package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.ForumApplication;
import com.twopythons.forum.model.entity.Message;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
class MessageServiceImplTest {

    @Autowired
    private MessageServiceImpl messageService;

    @Test
    void reply() {

        Message question = messageService.getById(1L).orElse(new Message());
        Message answer = messageService.getById(2L).orElse(new Message());
        messageService.reply(question, answer);
        Assert.assertEquals(1L, (long) messageService.getById(2L).orElse(new Message()).getRepliedTo().getId());

    }
}