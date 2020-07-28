package com.twopythons.forum.model.entity;

import com.twopythons.forum.model.entity.enums.ThemeState;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
@Table(name = "theme")
public class Theme extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
    private String title;
    private String description;
    private Calendar date;
    @Enumerated(EnumType.ORDINAL)
    private ThemeState state;

    @OneToMany(mappedBy = "theme")
    private Collection<Message> messages;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tagged",
                joinColumns = @JoinColumn(name = "theme_id"),
                inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Collection<Tag> tags;

    @ManyToMany(mappedBy = "upvotedThemes")
    private Set<User> upvotes;
    @ManyToMany(mappedBy = "downvotedThemes")
    private Set<User> downvotes;

}