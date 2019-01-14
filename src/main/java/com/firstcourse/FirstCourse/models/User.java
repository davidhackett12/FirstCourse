package com.firstcourse.FirstCourse.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int Id;

    @NotNull(message = "First Name is Required")
    @NotEmpty(message = "First Name is Required")
    private String firstName;

    @NotNull(message = "Last Name is Required")
    @NotEmpty(message = "Last Name is Required")
    private String lastName;

    @NotNull(message = "Email is Required")
    @NotEmpty(message = "Email is Required")
    @Email(message = "Invalid Email")
    private String email;

    @NotNull(message = "Password is Required")
    @NotEmpty(message = "Password is Required")
    @Size(min=5, message = "Password must be at least 5 characters")
    private String password;

    private int active;

    @ManyToMany
    private List<Role> role;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, int active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.active = active;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> roles) {
        this.role = roles;
    }

    public void addRole(Role newRole){
        role.add(newRole);
    }

}
