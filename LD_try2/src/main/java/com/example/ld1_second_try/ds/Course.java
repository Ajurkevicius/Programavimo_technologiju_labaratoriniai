package com.example.ld1_second_try.ds;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.property.access.internal.PropertyAccessStrategyIndexBackRefImpl;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String startDate;
    private String endDate;

    @ManyToMany(mappedBy = "myModeratedCourses", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("id ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> courseModerators;

    @ManyToMany(mappedBy = "myEnrolledCourses", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("id ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Student> students;

    @OneToMany(mappedBy = "parentCourse", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("id ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Folder> courseFolder;



    public Course(String title, List<User> courseModerators) {
        this.title = title;
        this.courseModerators = courseModerators;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<User> getCourseModerators() {
        return courseModerators;
    }

    public void setCourseModerators(List<User> courseModerators) {
        this.courseModerators = courseModerators;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Folder> getCourseFolder() {
        return courseFolder;
    }

    public void setCourseFolder(List<Folder> courseFolder) {
        this.courseFolder = courseFolder;
    }


    //mano kursas zino kokie yra vartotojai, kursas zino kokie yra moderatoriai;
// rysys many to many

}
