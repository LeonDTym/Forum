package com.twopythons.forum.model.service.impl;

import com.twopythons.forum.ForumApplication;
import com.twopythons.forum.model.entity.Theme;
import com.twopythons.forum.model.entity.enums.ThemeState;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForumApplication.class)
class ThemeServiceImplTest {

    @Autowired
    private ThemeServiceImpl themeService;

    @Test
    void changeThemeStateById() {

        themeService.getById(1L).ifPresent(theme -> themeService.changeThemeStateById(1L, ThemeState.Closed));
        Assert.assertEquals(ThemeState.Closed, themeService.getById(1L).orElse(new Theme()).getState());

        themeService.getById(1L).ifPresent(theme -> themeService.changeThemeStateById(1L, ThemeState.Active));
        Assert.assertEquals(ThemeState.Active, themeService.getById(1L).orElse(new Theme()).getState());

    }

    @Test
    void getAllThemesByUserId() {

        Theme theme = themeService.getAllThemesByUserId(1L).get(0);
        Assert.assertEquals("python", theme.getTitle());

    }

    @Test
    void addRemoveTag() {

        String tagTitle = "#Programming";

        themeService.getById(1L).ifPresent(theme -> {
            themeService.removeTag(theme, tagTitle);
            Assert.assertFalse(theme.getTags().stream().anyMatch(tag -> tag.getName().equals(tagTitle)));
        });

        themeService.getById(1L).ifPresent(theme -> {
            themeService.addTag(theme, tagTitle);
            Assert.assertTrue(theme.getTags().stream().anyMatch(tag -> tag.getName().equals(tagTitle)));
        });

    }

    @Test
    void findAllByTitle() {

        String themeTitle = "python";

        themeService.findAllByTitle(themeTitle, PageRequest.of(0, 10))
                .stream()
                .findFirst()
                .ifPresent(theme -> {
                    Assert.assertEquals(themeTitle, theme.getTitle());
                });

        themeService.findAllByTitle("pyth", PageRequest.of(0, 10))
                .stream()
                .findFirst()
                .ifPresent(theme -> {
                    Assert.assertEquals(themeTitle, theme.getTitle());
                });

        themeService.findAllByTitle("typon", PageRequest.of(0, 10))
                .stream()
                .findFirst()
                .ifPresent(theme -> {
                    Assert.assertNotEquals(themeTitle, theme.getTitle());
                });

    }

    @Test
    public void findByTag() {

        String themeTitle = "python";

        themeService.findByTag("#Programming", PageRequest.of(0, 10))
                .stream()
                .findFirst()
                .ifPresent(theme -> {
                    Assert.assertEquals(themeTitle, theme.getTitle());
                });
        themeService.findByTag("#python", PageRequest.of(0, 10))
                .stream()
                .findFirst()
                .ifPresent(theme -> {
                    Assert.assertEquals(themeTitle, theme.getTitle());
                });
        themeService.findByTag("#a", PageRequest.of(0, 10))
                .stream()
                .findFirst()
                .ifPresent(theme -> {
                    Assert.assertNotEquals(themeTitle, theme.getTitle());
                });
    }
}