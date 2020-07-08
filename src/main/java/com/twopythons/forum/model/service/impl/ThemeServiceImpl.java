package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.Theme;
import com.twopythons.forum.model.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeServiceImpl extends ServiceCommonImpl<Theme, ThemeRepository> {
    @Autowired
    public ThemeServiceImpl(ThemeRepository repository) {
        super(repository);
    }
}
