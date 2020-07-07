package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.Message;
import com.twopythons.forum.model.repository.MessageRepository;

public class MessageServiceImpl extends ServiceCommonImpl<Message, MessageRepository> {
    public MessageServiceImpl(MessageRepository repository) {
        super(repository);
    }
}
