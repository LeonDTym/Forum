package com.twopythons.forum.controller.mapper;

import com.twopythons.forum.model.dto.MessageDto;
import com.twopythons.forum.model.entity.Message;
import com.twopythons.forum.model.entity.Theme;
import com.twopythons.forum.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface MessageMapper extends CommonMapper<Message, MessageDto> {

    @Override
    @Mapping(source = "theme", target = "themeId", qualifiedByName = "getIdOfEntity")
    @Mapping(source = "author", target = "authorId", qualifiedByName = "getIdOfEntity")
    MessageDto entityToDto(Message entity);

    @Override
    @Mapping(source = "themeId", target = "theme", qualifiedByName = "getThemeById")
    @Mapping(source = "authorId", target = "author", qualifiedByName = "getAuthorById")
    Message dtoToEntity(MessageDto dto);

    @Named("getAuthorById")
    default User getAuthorById(Long id) {

        User author = new User();
        author.setId(id);
        return author;

    }

    @Named("getThemeById")
    default Theme getThemeById(Long id) {

        Theme theme = new Theme();
        theme.setId(id);
        return theme;

    }


}
