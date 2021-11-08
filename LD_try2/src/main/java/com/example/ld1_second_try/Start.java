package com.example.ld1_second_try;

import com.example.ld1_second_try.ds.*;
import com.example.ld1_second_try.hibernateControllers.CourseHibControl;
import com.example.ld1_second_try.hibernateControllers.FileHibControl;
import com.example.ld1_second_try.hibernateControllers.FolderHibControl;
import com.example.ld1_second_try.hibernateControllers.UserHibControl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Start {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CourseSystemMng");
        UserHibControl userHibControl = new UserHibControl(entityManagerFactory);
        CourseHibControl courseHibControl = new CourseHibControl(entityManagerFactory);
        FolderHibControl folderHibControl = new FolderHibControl(entityManagerFactory);
        FileHibControl fileHibControl = new FileHibControl(entityManagerFactory);
        FolderHibControl folderHibControl1 = new FolderHibControl(entityManagerFactory);
        //  FileHibControl fileHibControl1 = new FileHibControl(entityManagerFactory);
        // BANDYMAI SU FAILAIS


        Folder folder = folderHibControl.getFolderById(17);
        File file = new File("Test file 4", "Folder 17", folder );
        fileHibControl.createFile(file);

        //  fileHibControl.removeFile(4);


    /*
    VEIKIAAAAAA
        Folder folder = folderHibControl.getFolderById(17);
        //System.out.println(folder);
       List<File> folderFiles = folder.getFolderFiles();
      //  System.out.println(folderFiles);
        folderFiles.remove(0);
        folderHibControl1.editFolder(folder);
     */



        /*
        NEPAVYKE TESTAI

        Folder folder = folderHibControl.getFolderById(17);
        File file = fileHibControl.getFileById(4);
        List<File> folderFiles= folder.getFolderFiles();
        folderFiles.remove(file);
        folderHibControl.editFolder(folder);
        fileHibControl.removeFile(4);
        */
      //  System.out.println(folder.getFolderFiles());

        //File file = new File("Test file 4", "Folder 6", folder );
        //fileHibControl.createFile(file);
      //  fileHibControl.removeFile(4);




        /*
        Folder folder = new Folder("Folder folder test 10");
        folder.setParentFolder(folderHibControl.getFolderById(21));
        folderHibControl.createFolder(folder);

        /*

        Suveike, bet taip daryti nereikia, nes vienas folderis priklauso keliems kursasms.
        As net nesuprantu, kaip hibernateas sugebejo ivykdyt sita query ir nesusipjaut
        Paprastu query nesugeba be erroru ivykdyt,o sudetingus net nemirktelejes.
        Hibernateas, toks keistas.
        Folder folder = new Folder("Folderio folderio testas 3");
        Course course = courseHibControl.getCourseById(8);
        folder.setParentFolder(folderHibControl.getFolderById(14));
       // folderHibControl.createFolder(folder);
        List<Folder> folders= new ArrayList<>();
        folders.add(folder);
        folder.setParentCourse(course);
        course.setCourseFolder(folders);
        courseHibControl.editCourse(course);
        */




        /*
        Folder folder = new Folder("Course test folder 1");
        Course course = courseHibControl.getCourseById(6);



        */

        /*
        Sitaip veikia, bet tai yra neitiketinai keista, kaip vienoje klaseje sugaudo rysi, kitoje magiskai ne
        Folder folder = new Folder("Course test folder 5");
        Course course = courseHibControl.getCourseById(6);
        List<Folder> folders= new ArrayList<>();
        folders.add(folder);
        folder.setParentCourse(course);
        course.setCourseFolder(folders);
        courseHibControl.editCourse(course);
        */

       // folderHibControl.createFolder(folder);



        //Course course= courseHibControl.getCourseById(11);
      //  courseHibControl.removeCourse(11);
        /*
        User user = userHibControl.getUserById(2);
        List<User> users = new ArrayList<>();
        users.add(user);

        Course course= new Course("Bandymas 15", users);
        user.getMyModeratedCourses().add(course);
        courseHibControl.createCourse(course);
        userHibControl.editUser(user);
*/



        // courseHibControl.createCourse(course);

/*
        Course course = new Course("Kursas5", users );
        student.getMyModeratedCourses().add(course);
        courseHibControl.createCourse(course);
        */
        //File file =fileHibControl.getFileById(2);
        //System.out.println(file);
      //  Folder folder = folderHibControl.getFolderById(5);
     //   File file = new File("Test File 3", "Folder2", folder );
       // fileHibControl.createFile(file);
       // fileHibControl.removeFile(2);
        //FolderHibControl folderHibControl1 = new FolderHibControl(entityManagerFactory);
       // Folder folder = new Folder("Testinis5.2");
      //  Folder folder1 = folderHibControl.getFolderById(6);
        //folderHibControl1.createFolder(folder1);
     //   System.out.println(folder1);
       // folder.setParentFolder(folder1);
      //  folderHibControl.createFolder(folder);
       // folder.setParentCourse(2);
       // folderHibControl.createFolder(folder);
       // folderHibControl.removeFolder(4);


        //  Student student = new Student("admin1","admin1","admin","admin","admin","admin");
       // userHibControl.createUser(student);
    //  User user1= userHibControl.getUserById(1);
       // System.out.println(user1);
      //  userHibControl.removeUser(1);
        /*
        List<User> users = new ArrayList<>();
        users.add(student);
*/
        /*
        Course course = new Course("Kursas5", users );
        student.getMyModeratedCourses().add(course);
        courseHibControl.createCourse(course);


         */

        /*
        Folder folder = new Folder("F1");
        Folder folder2 = new Folder("F2");
        Folder folder3 = new Folder("F3");

        List<Folder> folders = Arrays.asList(folder, folder2, folder3);

        Course course = new Course("Test course", users);
        course.setCourseFolder(folders);
        folder.setParentCourse(course);
        folder2.setParentCourse(course);
        folder3.setParentCourse(course);
        student.getMyModeratedCourses().add(course);
        courseHibControl.createCourse(course);

            */

    }
}
