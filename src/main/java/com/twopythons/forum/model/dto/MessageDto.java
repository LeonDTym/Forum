package com.twopythons.forum.model.dto;

import lombok.Data;

import java.util.Calendar;

@Data
public class MessageDto extends AbstractDto {

    private Long themeId;
    private Long userId;
    private Long repliedToMessageId;
    private Calendar date;
    private int rating;
    private String text;

}
