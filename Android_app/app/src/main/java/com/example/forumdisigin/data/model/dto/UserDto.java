package com.example.forumdisigin.data.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

import lombok.Data;

@Data
public class UserDto extends AbstractDto {

    @Size(min = 6, max = 20)
    private String login;
    @Size(min = 6, max = 20)
    private String password;
    @Email
    private String email;
    @Size(max = 5242880) //5 Mb
    private byte[] picture;
    private boolean isNonLocked;

    private Collection<Long> themesId;
    private Collection<Long> messagesId;
    private Set<String> roles;

}
