module com.example.ld1_second_try {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;

    opens com.example.ld1_second_try to javafx.fxml;
    exports com.example.ld1_second_try;

    opens com.example.ld1_second_try.ds to javafx.fxml, org.hibernate.orm.core, java.persistence;
    exports com.example.ld1_second_try.ds;
    exports com.example.ld1_second_try.fxControllers to javafx.fxml;
    opens com.example.ld1_second_try.fxControllers to javafx.fxml;
}