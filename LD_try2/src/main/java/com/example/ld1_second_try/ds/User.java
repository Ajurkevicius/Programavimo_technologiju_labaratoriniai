package com.example.ld1_second_try.ds;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private LocalDate dateCreated;
    private LocalDate dateModified;
    private boolean isActive;
    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

    @ManyToMany
    private List<Course> myModeratedCourses;

    @ManyToMany
    private List<Folder> myFolders;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.dateCreated= LocalDate.now();
        this.isActive=true;
        this.userType = UserType.ADMIN;
        this.myModeratedCourses=new ArrayList<>();
    }



    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<Course> getMyModeratedCourses() {
        return myModeratedCourses;
    }

    public void setMyModeratedCourses(List<Course> myModeratedCourses) {
        this.myModeratedCourses = myModeratedCourses;
    }

    public List<Folder> getMyFolders() {
        return myFolders;
    }

    public void setMyFolders(List<Folder> myFolders) {
        this.myFolders = myFolders;
    }

    @Override
    public String toString() {
        return "User" +
                "id=" + id +
                "surname=" + username +
                ", datecreated='" + dateCreated + '\'' +
                ", date modified=" + dateModified +
                ", isactive=" + isActive +
                '}';
    }


}
