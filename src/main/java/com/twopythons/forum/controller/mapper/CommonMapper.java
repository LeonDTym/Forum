package com.twopythons.forum.controller.mapper;

import com.twopythons.forum.model.dto.AbstractDto;
import com.twopythons.forum.model.entity.*;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;


public interface CommonMapper<E extends AbstractEntity, D extends AbstractDto> {

    D entityToDto(E entity);

    E dtoToEntity(D dto);

    default List<E> dtosToEntities(List<D> dtos) {
        List<E> entities = new ArrayList<>();
        for(D dto: dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }

    default List<D> entitiesToDtos(List<E> entities) {
        List<D> dtos = new ArrayList<>();
        for(E entity: entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Named("getIdOfEntity")
    default <T extends AbstractEntity> Long getIdOfEntity(T entity) { return entity.getId(); }

    @Named("getUserById")
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

    @Named("getMessageById")
    default Message getMessageById(Long id) {

        Message message = new Message();
        message.setId(id);
        return message;

    }

    @Named("getTagById")
    default Tag getTagById(Long id) {

        Tag tag = new Tag();
        tag.setId(id);
        return tag;

    }

}