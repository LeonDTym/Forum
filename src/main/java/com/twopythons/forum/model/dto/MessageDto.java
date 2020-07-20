package com.twopythons.forum.model.dto;

import lombok.Data;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Data
public class MessageDto extends AbstractDto {

    private Long themeId;
    private Long userId;
    private Long repliedToMessageId;
    @PastOrPresent
    private Calendar date;
    private int rating;
    @Size(max = 65536)
    private String text;

}
