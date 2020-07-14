package com.twopythons.forum.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Data
@Entity
@Table(name = "user")
public class User extends AbstractEntity {

    private String login;
    private String password;
    private String email;
    private byte[] picture;
    @OneToMany(mappedBy = "user")
    private Collection<Theme> themes;
    @OneToMany(mappedBy = "author")
    private Collection<Message> sentMessages;

}
