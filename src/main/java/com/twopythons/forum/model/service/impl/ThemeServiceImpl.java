package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.Theme;
import com.twopythons.forum.model.repository.ThemeRepository;

public class ThemeServiceImpl extends ServiceCommonImpl<Theme, ThemeRepository> {
    public ThemeServiceImpl(ThemeRepository repository) {
        super(repository);
    }
}
