package com.twopythons.forum.controller.mapper;

import com.twopythons.forum.model.dto.MessageDto;
import com.twopythons.forum.model.entity.AbstractEntity;
import com.twopythons.forum.model.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface MessageMapper extends CommonMapper<Message, MessageDto> {

    @Override
    @Mapping(source = "theme", target = "themeId", qualifiedByName = "getEntityId")
    @Mapping(source = "author", target = "authorId", qualifiedByName = "getEntityId")
    MessageDto entityToDto(Message entity);

    @Named("getEntityId")
    default Long getEntityId(AbstractEntity entity) { return entity.getId(); }

}
