package com.twopythons.forum.model.service;

import com.twopythons.forum.model.entity.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    void createMessage(Message message);
    void changeMessage(Message message);
    void deleteMessageById(Long id);
    Optional<Message> getMessageById(Long id);
    List<Message> getAllMessages();
}
