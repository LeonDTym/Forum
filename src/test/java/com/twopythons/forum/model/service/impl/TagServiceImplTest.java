package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.ForumApplication;
import com.twopythons.forum.model.entity.Tag;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
class TagServiceImplTest {

    @Autowired
    private TagServiceImpl tagService;

    @Test
    void getTagByName() {

        Tag tag = tagService.getTagByName("newTag");

        Assert.assertEquals(
                tagService.repository.findTagByName("newTag").orElse(new Tag()).getName(),
                tag.getName());

    }
}