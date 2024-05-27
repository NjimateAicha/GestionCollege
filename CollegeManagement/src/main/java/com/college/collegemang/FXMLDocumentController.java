package com.college.collegemang;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author WINDOWS 10
 */
public class FXMLDocumentController  {

    @FXML
    private AnchorPane login_form;

    @FXML
    private TextField login_username;

    @FXML
    private PasswordField login_password;

    @FXML
    private Button login_btn;



    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private  AlertMessage alert = new AlertMessage();

    public void loginAccount() {

        if (login_username.getText().isEmpty()
                || login_password.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {

            String selectData = "SELECT * FROM users WHERE username = ? AND password = ?";

            connect = Database.connectDB();

            String role = "";
            try {
                prepare = connect.prepareStatement(selectData);
                prepare.setString(1, login_username.getText());
                prepare.setString(2, login_password.getText());

                result = prepare.executeQuery();

                if (result.next()) {
                    role = result.getString("role");

                    //System.out.println(role);

                    Thread.sleep(1000);

                    if (role.equals("Admin")) {
                        ListData.admin_username = login_username.getText();
                        // LINK YOUR MAIN FORM FOR ADMIN
                        Parent root = FXMLLoader.load(getClass().getResource("AdminMainForm.fxml"));

                        Stage stage = new Stage();
                        stage.setTitle("College Management System | Admin Portal");
                        stage.setScene(new Scene(root));

                        stage.show();

                        // TO HIDE YOUR LOGIN FORM
                        login_btn.getScene().getWindow().hide();


                    } else if (role.equals("student")) {

                        String tempStudentID = result.getString("student_id");


                                ListData.student_username = login_username.getText();

                                Parent root = FXMLLoader.load(getClass().getResource("StudentMainForm.fxml"));
                                Stage stage = new Stage();

                                stage.setTitle("College Management System | Student Portal");
                                stage.setScene(new Scene(root));
                                stage.show();

                                // TO HIDE YOUR LOGIN FORM
                                login_btn.getScene().getWindow().hide();



                    }
                } else {
                    alert.errorMessage("Incorrect Username/Password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    private int studentID;

    public int studentIDGenerator() {
        String selectData = "SELECT MAX(id) FROM student";

        connect = Database.connectDB();

        int temp_studentID = 0;

        try {
            statement = connect.createStatement();
            result = statement.executeQuery(selectData);

            if (result.next()) {
                temp_studentID = result.getInt("MAX(id)");
            }

            if (temp_studentID == 0) {
                studentID = 1;
            } else {
                studentID = temp_studentID + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentID;
    }

}