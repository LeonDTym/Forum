package com.twopythons.forum.model.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Collection;

@Data
public class TagDto extends AbstractDto {

    @Pattern(regexp = "(?:\\s|^)#[A-Za-z0-9\\-\\.\\_]+(?:\\s|$)")
    private String name;
    private Collection<Long> themesId;

}
