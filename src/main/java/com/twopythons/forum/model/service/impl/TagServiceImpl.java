package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.Tag;
import com.twopythons.forum.model.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagServiceImpl extends ServiceCommonImpl<Tag, TagRepository> {

    @Autowired
    public TagServiceImpl(TagRepository repository) {
        super(repository);
    }

    public Tag getTagByName(String name) {

        Optional<Tag> tag = repository.findTagByName(name);

        if(tag.isEmpty()) {
            Tag newTag = new Tag();
            newTag.setName(name);
            repository.save(newTag);
        }

        return repository.findTagByName(name).orElseThrow();
    }
}
