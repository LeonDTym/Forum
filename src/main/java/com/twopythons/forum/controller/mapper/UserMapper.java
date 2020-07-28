package com.twopythons.forum.controller.mapper;

import com.twopythons.forum.model.dto.UserDto;
import com.twopythons.forum.model.entity.Role;
import com.twopythons.forum.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper extends CommonMapper<User, UserDto> {

    @Override
    @Mapping(source = "sentMessages", target = "messagesId", qualifiedByName = "getIdOfEntity")
    @Mapping(source = "themes", target = "themesId", qualifiedByName = "getIdOfEntity")
    @Mapping(source = "roles", target = "roles", qualifiedByName = "roleToString")
    UserDto entityToDto(User entity);

    @Override
    @Mapping(source = "messagesId", target = "sentMessages", qualifiedByName = "getMessageById")
    @Mapping(source = "themesId", target = "themes", qualifiedByName = "getThemeById")
    @Mapping(source = "roles", target = "roles", qualifiedByName = "getRoleByName")
    User dtoToEntity(UserDto dto);

    @Named("getRoleByName")
    default Role getRoleByName(String name) {

        Role role = new Role();
        role.setName(name);
        return role;

    }

    @Named("roleToString")
    default String roleToString(Role role) {
        return role.getName();
    }

}
