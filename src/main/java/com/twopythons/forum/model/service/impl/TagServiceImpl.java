package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.Tag;
import com.twopythons.forum.model.repository.TagRepository;

public class TagServiceImpl extends ServiceCommonImpl<Tag, TagRepository> {
    public TagServiceImpl(TagRepository repository) {
        super(repository);
    }
}
