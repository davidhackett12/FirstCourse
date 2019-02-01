package com.firstcourse.FirstCourse.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name="profile_id")
    private List<Post> posts;

    private String firstName;

    private String lastName;

    private String city;

    private String workPlace;

    private String job;

    public Profile() {
    }

    public Profile(User user, String firstName, String lastName) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post){
        this.posts.add(post);
    }
}
