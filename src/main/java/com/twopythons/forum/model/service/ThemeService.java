package com.twopythons.forum.model.service;

import com.twopythons.forum.model.entity.Theme;

import java.util.List;
import java.util.Optional;

public interface ThemeService {
    void createTheme(Theme theme);
    void changeTheme(Theme theme);
    void deleteThemeById(Long id);
    Optional<Theme> getThemeById(Long id);
    List<Theme> getAllThemes();
}
