package com.twopythons.forum.model.entity;

import com.twopythons.forum.model.entity.enums.ThemeState;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;

@Data
@Entity
@Table(name = "theme")
public class Theme {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String title;
    private String description;
    private Calendar date;
    @Enumerated(EnumType.ORDINAL)
    private ThemeState state;
    private int rating;

    @OneToMany(mappedBy = "theme")
    private Collection<Message> messages;
    @ManyToMany
    @JoinTable(name = "tagged",
                joinColumns = @JoinColumn(name = "theme_id"),
                inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Collection<Tag> tags;

}