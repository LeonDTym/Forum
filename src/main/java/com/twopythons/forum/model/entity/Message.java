package com.twopythons.forum.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;

@Data
@Entity
@Table(name = "message")
public class Message extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "replied_message_id")
    private Message repliedTo;
    @OneToMany(mappedBy = "repliedTo", fetch = FetchType.EAGER)
    private Collection<Message> repliedBy;
    private Calendar date;
    private int rating;
    private String text;

}
