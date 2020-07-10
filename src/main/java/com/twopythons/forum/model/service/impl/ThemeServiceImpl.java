package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.Tag;
import com.twopythons.forum.model.entity.Theme;
import com.twopythons.forum.model.entity.enums.ThemeState;
import com.twopythons.forum.model.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ThemeServiceImpl extends ServiceCommonImpl<Theme, ThemeRepository> {

    private final TagServiceImpl tagService;

    @Autowired
    public ThemeServiceImpl(ThemeRepository repository, TagServiceImpl tagService) {

        super(repository);
        this.tagService = tagService;

    }

    @Transactional
    public void changeThemeStateById(Long id, ThemeState themeState) {

        getById(id).ifPresent(theme -> theme.setState(themeState));

    }

    public void addTag(Theme theme, String tagTitle) {

        Tag tag = tagService.getTagByName(tagTitle);
        theme.getTags().add(tag);
        repository.save(theme);

    }

    public void removeTag(Theme theme, String tagTitle) {

        theme.getTags().removeIf(tag -> tag.getName().equals(tagTitle));
        repository.save(theme);

    }

    public List<Theme> getAllThemesByUserId(Long id) {
        return repository.getAllByUserId(id);
    }

}
