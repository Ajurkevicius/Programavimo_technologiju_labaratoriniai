package com.example.ld1_second_try.fxControllers;

import com.example.ld1_second_try.HelloApplication;
import com.example.ld1_second_try.ds.Course;
import com.example.ld1_second_try.ds.Folder;
import com.example.ld1_second_try.ds.User;
import com.example.ld1_second_try.hibernateControllers.CourseHibControl;
import com.example.ld1_second_try.hibernateControllers.FolderHibControl;
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

public class FolderForCourseForm   {


    public TextField folderIDForCourse;
    public TextField folderNameForCourse;
    public TextField folderNameForFolder;
    public TextField folderIDForFolder;

    public void createFolderForCourseButtonClicked(ActionEvent actionEvent) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CourseSystemMng");
        CourseHibControl courseHibControl = new CourseHibControl(entityManagerFactory);

        int courseID;
        try {
            courseID = Integer.parseInt(folderIDForCourse.getText());
        }
        catch (NumberFormatException e)
        {
            courseID = 0;
        }


        Folder folder = new Folder(folderNameForCourse.getText());
        Course course = courseHibControl.getCourseById(courseID);
        List<Folder> folders= new ArrayList<>();
        folders.add(folder);
        folder.setParentCourse(course);
        course.setCourseFolder(folders);
        courseHibControl.editCourse(course);

    }

    public void createFolderForFolderButtonClicked(ActionEvent actionEvent) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CourseSystemMng");
        FolderHibControl folderHibControl = new FolderHibControl(entityManagerFactory);

        int folderID;
        try {
            folderID = Integer.parseInt(folderIDForFolder.getText());
        }
        catch (NumberFormatException e)
        {
            folderID = 0;
        }

        Folder folder = new Folder(folderNameForFolder.getText());
        folder.setParentFolder(folderHibControl.getFolderById(folderID));
        folderHibControl.createFolder(folder);

    }

    public void returntoMainForm(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-window.fxml"));
        Parent root =fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) folderNameForCourse.getScene().getWindow(); // nesuprantu kaip tai turetu veikti

        stage.setTitle("Main window");
        stage.setScene(scene);
        stage.show();
    }
}
