package com.twopythons.forum.model.dto;

import lombok.Data;

import java.util.Collection;
import java.util.Set;

@Data
public class UserDto extends AbstractDto {

    private String login;
    private String password;
    private String email;
    private byte[] picture;
    private boolean isNonLocked;

    private Collection<Long> themesId;
    private Collection<Long> messagesId;
    private Set<String> roles;

}
