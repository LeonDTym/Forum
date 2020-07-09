package com.twopythons.forum.model.repository;

import com.twopythons.forum.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
