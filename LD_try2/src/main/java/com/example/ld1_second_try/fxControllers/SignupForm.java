package com.example.ld1_second_try.fxControllers;

import com.example.ld1_second_try.HelloApplication;
import com.example.ld1_second_try.ds.Student;
import com.example.ld1_second_try.hibernateControllers.UserHibControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupForm implements Initializable {
    @FXML
    public RadioButton signupStudent; // this is for radio button
    @FXML
    public TextField signupUsername;
    @FXML
    public PasswordField signupPassword;
    @FXML
    public TextField signupName;
    @FXML
    public TextField signupSurname;
    @FXML
    public TextField signupCardnumber;
    @FXML
    public TextField signupStudentNumber;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void createUser(ActionEvent actionEvent) throws IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CourseSystemMng");
        UserHibControl userHibControl = new UserHibControl(entityManagerFactory);
        //Student student = new Student("admin1","admin1","admin","admin","admin","admin");

        if (signupStudent.isSelected()) {
            Student student = new Student(signupUsername.getText(), signupPassword.getText(), signupName.getText(), signupSurname.getText(), signupCardnumber.getText(), signupStudentNumber.getText());
            userHibControl.createUser(student);

            // todo validation if something went wrong

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-window.fxml"));
            Parent root =fxmlLoader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) signupUsername.getScene().getWindow(); // nesuprantu kaip tai turetu veikti

            stage.setTitle("Main window");
            stage.setScene(scene);
            stage.show();


        }


    }

    public void returnToLogin(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start-window.fxml"));
        Parent root =fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) signupUsername.getScene().getWindow(); // nesuprantu kaip tai turetu veikti

        stage.setTitle("Main window");
        stage.setScene(scene);
        stage.show();

    }
}
