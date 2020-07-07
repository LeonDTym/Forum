package com.twopythons.forum.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Calendar;

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
    @JoinColumn(name = "replied_user_id")
    private User repliedTo;
    private Calendar date;
    private int rating;
    private String text;

}
