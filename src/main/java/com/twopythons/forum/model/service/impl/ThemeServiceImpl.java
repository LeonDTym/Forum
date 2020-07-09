package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.Theme;
import com.twopythons.forum.model.entity.enums.ThemeState;
import com.twopythons.forum.model.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ThemeServiceImpl extends ServiceCommonImpl<Theme, ThemeRepository> {
    @Autowired
    public ThemeServiceImpl(ThemeRepository repository) {
        super(repository);
    }

    @Transactional
    public void changeThemeStateById(Long id, ThemeState themeState) {

        getById(id).ifPresent(theme -> theme.setState(themeState));

    }

    public List<Theme> getAllThemesByUserId(Long id) {

        return repository.getAllByUserId(id);

    }
}
