package com.example.forumdisigin.data.model.httpmanager;

import com.example.forumdisigin.data.model.dto.TagDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TagManagerTest {

    TagManager tagManager;

    @Before
    public void setup() {

        tagManager = new TagManager();

    }

    @Test
    public void getAll() throws JsonProcessingException, ClassNotFoundException {

        List<TagDto> tags = tagManager.getAll();
        Assert.assertFalse(tags.isEmpty());

    }

    @Test
    public void getById() throws JsonProcessingException, ClassNotFoundException {

        Long tagId = 1L;
        TagDto tag = tagManager.getById(tagId);
        Assert.assertEquals(tagId, tag.getId());

    }

    @Test
    public void add() {

        TagDto tag = new TagDto();

        String validTag = "#mysometag";
        String existingTag = "#programming";
        String invalidTag = "228";

        int code;

        tag.setName(validTag);
        code = tagManager.add(tag);
        Assert.assertEquals(201, code);

        tag.setName(existingTag);
        code = tagManager.add(tag);
        Assert.assertEquals(201, code);

        tag.setName(invalidTag);
        code = tagManager.add(tag);
        Assert.assertNotEquals(201, code);
    }
}