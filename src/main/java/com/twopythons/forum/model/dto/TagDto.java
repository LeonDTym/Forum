package com.twopythons.forum.model.dto;

import lombok.Data;

import java.util.Collection;

@Data
public class TagDto extends AbstractDto {

    private String name;
    private Collection<ThemeDto> themesId;

}
