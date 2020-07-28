package com.twopythons.forum.controller.mapper;

import com.twopythons.forum.model.dto.TagDto;
import com.twopythons.forum.model.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TagMapper extends CommonMapper<Tag, TagDto> {

    @Override
    @Mapping(source = "themes", target = "themesId", qualifiedByName = "getIdOfEntity")
    TagDto entityToDto(Tag entity);

    @Override
    @Mapping(source = "themesId", target = "themes", qualifiedByName = "getThemeById")
    Tag dtoToEntity(TagDto dto);

}
