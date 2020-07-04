package com.twopythons.forum.model.entity;

import com.twopythons.forum.model.entity.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private String email;
    @Enumerated(EnumType.ORDINAL)
    private Role role;
    private byte[] picture;

}
