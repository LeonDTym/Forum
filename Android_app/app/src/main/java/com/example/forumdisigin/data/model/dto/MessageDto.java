package com.example.forumdisigin.data.model.dto;

import lombok.Data;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Collection;

@Data
public class MessageDto extends AbstractDto {

    private Long themeId;
    private Long authorId;
    private Long repliedToMessageId;
    private Collection<Long> repliedByMessagesId;
    @PastOrPresent
    private Calendar date;
    private int rating;
    @Size(max = 65536)
    private String text;

}
