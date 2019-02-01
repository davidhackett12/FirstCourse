package com.firstcourse.FirstCourse.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private int id;

    private String text;

    private Date date;

    @ManyToOne
    private Profile profile;

    public Post() {
    }

    public Post(String text, Date date, Profile profile) {
        this.text = text;
        this.date = date;
        this.profile = profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
