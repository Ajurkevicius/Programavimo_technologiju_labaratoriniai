package com.example.ld1_second_try.fxControllers;

import com.example.ld1_second_try.HelloApplication;
import com.example.ld1_second_try.ds.Course;
import com.example.ld1_second_try.ds.User;
import com.example.ld1_second_try.hibernateControllers.CourseHibControl;
import com.example.ld1_second_try.hibernateControllers.UserHibControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseForm {
    public TextField courseNamePopulated;
    public TextField idForCoursePopulated;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CourseSystemMng");
    CourseHibControl courseHibControl = new CourseHibControl(entityManagerFactory);
    UserHibControl userHibControl = new UserHibControl(entityManagerFactory);

    public void createCourseFromForm(ActionEvent actionEvent) {

        int usersID;
        try {
            usersID = Integer.parseInt(idForCoursePopulated.getText());
        }
        catch (NumberFormatException e)
        {
            usersID = 0;
        }

        User user = userHibControl.getUserById(usersID);
        List<User> users = new ArrayList<>();
        users.add(user);

        /*
        Course course = new Course("Kursas5", users );
        student.getMyModeratedCourses().add(course);
        courseHibControl.createCourse(course);
        */

        Course course= new Course(courseNamePopulated.getText(), users);
        user.getMyModeratedCourses().add(course);
        courseHibControl.createCourse(course);
        userHibControl.editUser(user);
       // courseHibControl.createCourse(course);



    }

    public void returnFromCourseToMain(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-window.fxml"));
        Parent root =fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) courseNamePopulated.getScene().getWindow(); // nesuprantu kaip tai turetu veikti

        stage.setTitle("Main window");
        stage.setScene(scene);
        stage.show();

    }
}
