package com.college.collegemang;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EmploiController  {
    @FXML
    Button Xbtn;
    @FXML
    Button Mbtn;
    @FXML
    private Label C11;

    @FXML
    private Label C12;

    @FXML
    private Label C13;

    @FXML
    private Label C14;

    @FXML
    private Label C15;

    @FXML
    private Label C16;

    @FXML
    private Label C17;
    @FXML
    private Label C18;

    @FXML
    private Label C21;

    @FXML
    private Label C22;

    @FXML
    private Label C23;

    @FXML
    private Label C24;

    @FXML
    private Label C25;

    @FXML
    private Label C26;

    @FXML
    private Label C27;

    @FXML
    private Label C28;

    @FXML
    private Label C31;

    @FXML
    private Label C32;

    @FXML
    private Label C33;

    @FXML
    private Label C34;

    @FXML
    private Label C35;

    @FXML
    private Label C36;

    @FXML
    private Label C37;

    @FXML
    private Label C38;

    @FXML
    private Label C41;

    @FXML
    private Label C42;

    @FXML
    private Label C43;

    @FXML
    private Label C44;

    @FXML
    private Label C45;

    @FXML
    private Label C46;

    @FXML
    private Label C47;

    @FXML
    private Label C48;

    @FXML
    private Label C51;

    @FXML
    private Label C52;

    @FXML
    private Label C53;

    @FXML
    private Label C54;

    @FXML
    private Label C55;

    @FXML
    private Label C56;

    @FXML
    private Label C57;

    @FXML
    private Label C58;

    @FXML
    private Label C61;

    @FXML
    private Label C62;

    @FXML
    private Label C63;

    @FXML
    private Label C64;

    @FXML
    private Label C65;

    @FXML
    private Label C66;

    @FXML
    private Label C67;

    @FXML
    private Label C68;


    private Stage stage;
    private Scene scene;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;








    public void addStudentsShowListData() {
        String sql = "SELECT course.* FROM course, student WHERE course.course = student.course AND student_id = ?";
        try {
            Label[][] labels = {{C11, C12, C13, C14, C15, C16, C17, C18},
                    {C21, C22, C23, C24, C25, C26, C27, C28},
                    {C31, C32, C33, C34, C35, C36, C37, C38},
                    {C41, C42, C43, C44, C45, C46, C47, C48},
                    {C51, C52, C53, C54, C55, C56, C57, C58},
                    {C61, C62, C63, C64, C65, C66, C67, C68}
            };


            connect = Database.connectDB(); // Établir la connexion avant la préparation de la déclaration
            PreparedStatement prepare = connect.prepareStatement(sql);

              prepare.setString(1, "20230019");
          //  prepare.setString(1, cureentstudent );

            // Remplacez "currentStudentId" par la variable réelle currentStudentId



            int i=0,j=0;
            assert connect != null;

            result = prepare.executeQuery();
            while(result.next())
            { String jour = result.getString("Jour");
                if (jour.equalsIgnoreCase("lundi"))   i=0;
                if (jour.equalsIgnoreCase("mardi"))   i=1;
                if (jour.equalsIgnoreCase("mercredi"))   i=2;
                if (jour.equalsIgnoreCase("jeudi"))   i=3;
                if (jour.equalsIgnoreCase("vendredi"))   i=4;
                if (jour.equalsIgnoreCase("samedi"))   i=5;
                int StartTime = result.getInt("StartTime");
                if(StartTime == 8) j=0;
                if(StartTime == 9) j=1;
                if(StartTime == 10) j=2;
                if(StartTime == 11) j=3;
                if(StartTime == 14) j=4;
                if(StartTime == 15) j=5;
                if(StartTime == 16) j=6;
                if(StartTime == 17) j=7;
                labels[i][j].setText(result.getString("course") + "\n" + result.getString("full_name") );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void exit(ActionEvent e ){
        Stage stage = (Stage) Mbtn.getScene().getWindow();
        stage.close();
        addStudentsShowListData();
    }

    public void minimize(ActionEvent e){
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setIconified(true);
        addStudentsShowListData();

    }

}