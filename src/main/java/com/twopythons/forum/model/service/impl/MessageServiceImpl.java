package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.Message;
import com.twopythons.forum.model.repository.MessageRepository;
import com.twopythons.forum.model.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void createMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void changeMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void deleteMessageById(Long id) {
        getMessageById(id).ifPresent(message -> messageRepository.delete(message));
    }

    @Override
    public Optional<Message> getMessageById(Long id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
