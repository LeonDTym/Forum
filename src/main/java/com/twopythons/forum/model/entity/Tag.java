package com.twopythons.forum.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Data
@Entity
@Table(name = "tag")
public class Tag extends AbstractEntity {

    private String name;

    @ManyToMany(mappedBy = "tags")
    Collection<Theme> themes;

}
