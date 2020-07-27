package com.twopythons.forum.controller.mapper;

import com.twopythons.forum.ForumApplication;
import com.twopythons.forum.model.dto.MessageDto;
import com.twopythons.forum.model.entity.Message;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.GregorianCalendar;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
class MessageMapperTest {

    @Autowired
    MessageMapper messageMapper;

    @Test
    public void dtoToEntity() {

        MessageDto dto = new MessageDto();
        dto.setId(2L);
        dto.setDate(new GregorianCalendar(2001, 2,2));
        dto.setAuthorId(2L);
        dto.setThemeId(1L);

        Message entity = messageMapper.dtoToEntity(dto);

        System.out.println(entity.getAuthor().getId() + " " + entity.getTheme().getId());

    }
}