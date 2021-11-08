package com.example.ld1_second_try.fxControllers;

import com.example.ld1_second_try.ds.Course;
import com.example.ld1_second_try.ds.User;
import com.example.ld1_second_try.hibernateControllers.CourseHibControl;
import com.example.ld1_second_try.hibernateControllers.UserHibControl;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginWindow_not_working implements Initializable {

    //private int vienas =1;
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CourseSystemMng");
    CourseHibControl courseHibControl = new CourseHibControl(entityManagerFactory);
    UserHibControl userHibControl = new UserHibControl(entityManagerFactory);


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    public void populateAllUsers(MouseEvent mouseEvent){

        User selectedUser = userHibControl.getUserById(2);
        //User user = new User( userHibControl.getUserById(1));
    }
}
