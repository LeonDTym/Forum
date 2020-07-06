package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.model.entity.Theme;
import com.twopythons.forum.model.repository.ThemeRepository;
import com.twopythons.forum.model.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeServiceImpl implements ThemeService {

    private ThemeRepository themeRepository;

    @Autowired
    public ThemeServiceImpl(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @Override
    public void createTheme(Theme theme) {
        themeRepository.save(theme);
    }

    @Override
    public void changeTheme(Theme theme) {
        themeRepository.save(theme);
    }

    @Override
    public void deleteThemeById(Long id) {
        getThemeById(id).ifPresent(theme -> themeRepository.delete(theme));
    }

    @Override
    public Optional<Theme> getThemeById(Long id) {
        return themeRepository.findById(id);
    }

    @Override
    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }
}
