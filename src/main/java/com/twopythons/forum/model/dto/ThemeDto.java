package com.twopythons.forum.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Collection;

@Data
public class ThemeDto extends AbstractDto {

    private Long authorId;
    @Size(min = 1, max = 255)
    private String title;
    @Size(max = 65536)
    private String description;
    @PastOrPresent
    private Calendar date;
    @NotNull
    private String state;
    private int rating;

    private Collection<Long> messagesId;
    private Collection<Long> tagsId;

}
