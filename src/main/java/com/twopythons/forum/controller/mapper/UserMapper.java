package com.twopythons.forum.controller.mapper;

import com.twopythons.forum.model.dto.MessageDto;
import com.twopythons.forum.model.dto.UserDto;
import com.twopythons.forum.model.entity.Message;
import com.twopythons.forum.model.entity.Role;
import com.twopythons.forum.model.entity.User;
import com.twopythons.forum.model.repository.RoleRepository;
import com.twopythons.forum.model.service.impl.UserServiceImpl;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

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
    @Mapping(target = "roles", ignore = true)
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
