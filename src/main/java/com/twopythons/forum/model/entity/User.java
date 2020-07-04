package com.twopythons.forum.model.entity;

import com.twopythons.forum.model.entity.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

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

    @OneToMany(mappedBy = "user")
    private Collection<Theme> themes;
    @OneToMany(mappedBy = "author")
    private Collection<Message> sentMessages;
    @OneToMany(mappedBy = "repliedTo")
    private  Collection<Message> receivedMessages;
}
