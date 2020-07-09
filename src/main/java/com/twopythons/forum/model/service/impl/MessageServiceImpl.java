package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.Message;
import com.twopythons.forum.model.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceCommonImpl<Message, MessageRepository> {
    @Autowired
    public MessageServiceImpl(MessageRepository repository) {
        super(repository);
    }
}
