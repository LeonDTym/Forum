package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.Tag;
import com.twopythons.forum.model.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends ServiceCommonImpl<Tag, TagRepository> {
    @Autowired
    public TagServiceImpl(TagRepository repository) {
        super(repository);
    }
}
