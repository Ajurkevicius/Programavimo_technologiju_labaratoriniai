package com.example.ld1_second_try.fxControllers;

import com.example.ld1_second_try.HelloApplication;
import com.example.ld1_second_try.ds.Course;
import com.example.ld1_second_try.ds.Folder;
import com.example.ld1_second_try.hibernateControllers.CourseHibControl;
import com.example.ld1_second_try.hibernateControllers.UserHibControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        courseList.getItems().clear();

        List<Course> courses = courseHibControl.getAllCourses(true, -1, -1);
        courses.forEach(c -> courseList.getItems().add(c.getId() + ":" + c.getDescription()));
    }

    public ListView courseList;
    public TreeView courseFolderTree;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CourseSystemMng");
    CourseHibControl courseHibControl = new CourseHibControl(entityManagerFactory);
    UserHibControl userHibControl = new UserHibControl(entityManagerFactory);

    public void populateFolders(MouseEvent mouseEvent){

        String courseId = courseList.getSelectionModel().getSelectedItem().toString().split(":")[0];
        Course selectedCourse = courseHibControl.getCourseById(Integer.parseInt(courseId));
      //  Course selectedCourse = courseHibControl.getCourseById(2);

        courseFolderTree.setRoot(new TreeItem<String>("Course folders:"));
        selectedCourse.getCourseFolder().forEach(folder -> addTreeItem(folder, courseFolderTree.getRoot()));


    }

    private void addTreeItem(Folder folder, TreeItem parentFolder) {
        TreeItem<Folder> treeItem = new TreeItem<>(folder);
        parentFolder.getChildren().add(treeItem);
        folder.getSubFolder().forEach(sub -> addTreeItem(sub, treeItem));
    }

    public void addingACourse(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("course-form.fxml"));
        Parent root =fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) courseList.getScene().getWindow();

        stage.setTitle("Main window");
        stage.setScene(scene);
        stage.show();


    }

    public void creatingFolderInCourseFromMain(ActionEvent actionEvent) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("folderForCourse-form.fxml"));
        Parent root =fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) courseList.getScene().getWindow();

        stage.setTitle("Main window");
        stage.setScene(scene);
        stage.show();
    }

    public void addFile(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("files-form.fxml"));
        Parent root =fxmlLoader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) courseList.getScene().getWindow();

        stage.setTitle("Main window");
        stage.setScene(scene);
        stage.show();
    }
}
