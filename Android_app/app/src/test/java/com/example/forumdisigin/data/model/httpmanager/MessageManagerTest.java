package com.example.forumdisigin.data.model.httpmanager;

import com.example.forumdisigin.data.model.dto.MessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;


public class MessageManagerTest {

    MessageManager messageManager;

    @Before
    public void setup() {
        messageManager = new MessageManager();
    }

    @Test
    public void getAll() throws JsonProcessingException, ClassNotFoundException {

        List<MessageDto> messages = messageManager.getAll();
        Assert.assertFalse(messages.isEmpty());

    }

    @Test
    public void getById() throws JsonProcessingException, ClassNotFoundException {

        Long messageId = 1L;
        MessageDto message = messageManager.getById(messageId);
        Assert.assertEquals(messageId, message.getId());

    }

    @Test
    public void add() {

        MessageDto message = new MessageDto();
        message.setAuthorId(7L);
        message.setDate(Calendar.getInstance());
        message.setThemeId(1L);
        message.setRepliedToMessageId(1L);
        message.setText("haha you noob");

        int code = messageManager.add(message);
        Assert.assertEquals(201, code);

    }
}