package com.twopythons.forum.model.dto;

import com.twopythons.forum.model.entity.enums.ThemeState;
import lombok.Data;

import java.util.Calendar;
import java.util.Collection;

@Data
public class ThemeDto extends AbstractDto {

    private Long userId;
    private String title;
    private String description;
    private Calendar date;
    private ThemeState themeState;
    private int rating;

    private Collection<Long> messagesId;
    private Collection<Long> tagsId;

}
