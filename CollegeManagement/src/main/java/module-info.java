module com.college.collegemang {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.college.collegemang to javafx.fxml;
    exports com.college.collegemang;
    // opens UniversitiyManagementSystem to javafx.fxml;
}
