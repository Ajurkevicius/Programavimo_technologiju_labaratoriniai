package com.example.ld1_second_try.fxControllers;

import com.example.ld1_second_try.HelloApplication;
import com.example.ld1_second_try.ds.User;
import com.example.ld1_second_try.hibernateControllers.UserHibControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.ErrorManager;

public class StartWindow implements Initializable {
    @FXML
    public TextField loginF;
    @FXML
    public PasswordField passwordF;



    public void validateNLoad(ActionEvent actionEvent) throws IOException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CourseSystemMng");
        UserHibControl userHibControl = new UserHibControl(entityManagerFactory);
        User user = userHibControl.getAllUsers(true, -1, -1).stream().filter(c-> c.getUsername().equals(loginF.getText())).filter(c->c.getPassword().equals(passwordF.getText())).findFirst().orElse(null);
        if(user !=null){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-window.fxml"));
            Parent root =fxmlLoader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) loginF.getScene().getWindow();

            stage.setTitle("Main window");
            stage.setScene(scene);
            stage.show();
        }
        else{
            alertMessage("Oops something went wrong");
        }

    }
    private static void alertMessage(String s){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Message text:");
        alert.setContentText(s);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void openSignUP(ActionEvent actionEvent) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup-form.fxml"));
        Parent root =fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) loginF.getScene().getWindow();

        stage.setTitle("Main window");
        stage.setScene(scene);
        stage.show();

    }
}
