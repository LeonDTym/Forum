package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.Tag;
import com.twopythons.forum.model.repository.TagRepository;
import com.twopythons.forum.model.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public void createTag(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public void deleteTagById(Long id) {
        getTagById(id).ifPresent(tag -> tagRepository.delete(tag));
    }

    @Override
    public Optional<Tag> getTagById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
