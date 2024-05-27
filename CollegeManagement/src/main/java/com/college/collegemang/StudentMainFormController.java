package  com.college.collegemang;

import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author WINDOWS 10
 */
public class StudentMainFormController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Label greet_name;

    @FXML
    private Label teacher_id;

    @FXML
    private Button addStudent_btn;

    @FXML
    private Button subjectHandle_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private Label current_form;

    @FXML
    private AnchorPane addStudents_form;



    @FXML
    private TextField  addStudents_name;

    @FXML
    private TextField  addStudents_massar;


    @FXML
    private TextField  addStudents_classeSouh;

    @FXML
    private TextField addStudents_Justification;



    @FXML
    private Button addStudents_addBtn;


    @FXML
    private AnchorPane subjectHandle_form;


    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private AlertMessage alert = new AlertMessage();

    public void addStudentsAddBtn() {
        if (addStudents_name.getText().isEmpty()
                || addStudents_massar.getText().isEmpty()
                || addStudents_classeSouh.getText().isEmpty()
                || addStudents_Justification.getText().isEmpty()) {
           // alert.errorMessage("Please fill all blank fields");
        } else {
            String insertData = "INSERT INTO demande "
                    + "(name, massar, classeSouh, Justification, date_insert) VALUES(?,?,?,?,?)";
            connect = Database.connectDB();

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            try {
                prepare = connect.prepareStatement(insertData);

                prepare.setString(1, addStudents_name.getText());
                prepare.setString(2, addStudents_massar.getText());
                prepare.setString(3, addStudents_classeSouh.getText());
                prepare.setString(4, addStudents_Justification.getText());
                prepare.setString(5, String.valueOf(sqlDate));

                prepare.executeUpdate();

                alert.successMessage("Added successfully!");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Assurez-vous de fermer la connexion dans un bloc finally
                try {
                    if (connect != null) {
                        connect.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void Emploitemps() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Emploi.fxml"));

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Emploi du temps");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == addStudent_btn) {
            addStudents_form.setVisible(true);
            subjectHandle_form.setVisible(false);

            addStudentsAddBtn();

            current_form.setText("Add Students form");
        } else if (event.getSource() == subjectHandle_btn) {
            addStudents_form.setVisible(false);
            subjectHandle_form.setVisible(true);



            current_form.setText("Subject Handles form");
        }

    }

    public void logoutBtn() {
        try {
            if (alert.confirmMessage("Are you sure you want to logout?")) {
                // TO SHOW THE LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                stage.show();

                // TO HIDE YOUR MAIN FORM
                logout_btn.getScene().getWindow().hide();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void displayTeacher() {

        String sql = "SELECT * FROM users WHERE username = '"
                + ListData.teacher_username + "'";

        connect = Database.connectDB();

        String temp_teacherName = "";
        String temp_teacherID = "";

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                temp_teacherID = result.getString("teacher_id");
            }

            String selectData = "SELECT * FROM teacher WHERE teacher_id = '"
                    + temp_teacherID + "'";

            statement = connect.createStatement();
            result = statement.executeQuery(selectData);

            if (result.next()) {
                temp_teacherName = result.getString("full_name");
            }

            greet_name.setText("Welcome, " + temp_teacherName);
            teacher_id.setText(temp_teacherID);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        displayTeacher();

        addStudentsAddBtn();

    }

}
