package com.twopythons.forum.model.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
public class Role extends AbstractEntity implements GrantedAuthority {

    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    @Override
    public String getAuthority() {
        return name;
    }
}
