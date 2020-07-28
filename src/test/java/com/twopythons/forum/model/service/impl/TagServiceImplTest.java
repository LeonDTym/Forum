package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.ForumApplication;
import com.twopythons.forum.model.entity.Tag;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Test
    void pageTest() {

        Pageable request = PageRequest.of(0, 2, Sort.by("name").descending());
        Page<Tag> page;

        do {

            page = tagService.repository.findAll(request);
            request = request.next();

            page.forEach(tag -> System.out.println(tag.getId() + " " + tag.getName()));
            System.out.println("---------------- next page ----------------");

        } while(page.hasNext());

    }

}