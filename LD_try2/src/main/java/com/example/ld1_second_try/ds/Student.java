package com.example.ld1_second_try.ds;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Student extends User{

    private String name;
    private String surname;
    private String cardNumber;
    private String studentNumber;

    @ManyToMany
    List<Course> myEnrolledCourses;

    public Student() {
    }

    public Student(String username, String password, String name, String surname, String cardNumber, String studentNumber) {
        super(username, password);
        this.name = name;
        this.surname = surname;
        this.cardNumber = cardNumber;
        this.studentNumber = studentNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getMyEnrolledCourses() {
        return myEnrolledCourses;
    }

    public void setMyEnrolledCourses(List<Course> myEnrolledCourses) {
        this.myEnrolledCourses = myEnrolledCourses;
    }


}
