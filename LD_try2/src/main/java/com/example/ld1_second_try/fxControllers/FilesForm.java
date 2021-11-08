package com.example.ld1_second_try.fxControllers;

import com.example.ld1_second_try.HelloApplication;
import com.example.ld1_second_try.ds.File;
import com.example.ld1_second_try.ds.Folder;
import com.example.ld1_second_try.hibernateControllers.FileHibControl;
import com.example.ld1_second_try.hibernateControllers.FolderHibControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class FilesForm {
    public TextField folderIdForFile;
    public TextField fileName;
    public TextField fileLocation;

    public void createFile(ActionEvent actionEvent) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CourseSystemMng");
        FolderHibControl folderHibControl = new FolderHibControl(entityManagerFactory);
        FileHibControl fileHibControl = new FileHibControl(entityManagerFactory);

        int folderID;
        try {
            folderID = Integer.parseInt(folderIdForFile.getText());
        }
        catch (NumberFormatException e)
        {
            folderID = 0;
        }

        Folder folder = folderHibControl.getFolderById(folderID);
        File file = new File(fileName.getText(), fileLocation.getText(), folder );
        fileHibControl.createFile(file);
    }

    public void backToMainForm(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-window.fxml"));
        Parent root =fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) fileName.getScene().getWindow(); // nesuprantu kaip tai turetu veikti

        stage.setTitle("Main window");
        stage.setScene(scene);
        stage.show();
    }
}
