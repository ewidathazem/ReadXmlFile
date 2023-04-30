module com.example.readxmlfile {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.example.readxmlfile to javafx.fxml;
    exports com.example.readxmlfile;
}