package com.twopythons.forum.model.service;

import com.twopythons.forum.model.entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    void createTag(Tag tag);
    void deleteTagById(Long id);
    Optional<Tag> getTagById(Long id);
    List<Tag> getAllTags();
}
