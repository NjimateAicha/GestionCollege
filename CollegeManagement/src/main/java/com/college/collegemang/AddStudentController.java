package com.college.collegemang;



import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author WINDOWS 10
 */
public class AddStudentController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField student_number;

    @FXML
    private TextField student_name;

    @FXML
    private DatePicker student_birthDate;

    @FXML
    private ComboBox<String> student_niveau;

    @FXML
    private ComboBox<String> student_course;

    @FXML
    private ComboBox<String> student_section;

    @FXML
    private TextField student_emailPa;




    @FXML
    private Button student_addBtn;

    @FXML
    private Button student_updateBtn;





    @FXML
    private ComboBox<String> student_semester;

    @FXML
    private ComboBox<String> student_gender;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private Statement statement;

    private AlertMessage alert = new AlertMessage();

    private Image image;

    public AddStudentController() {
    }

    public void addBtn() {

        if (student_number.getText().isEmpty()
                || student_name.getText().isEmpty()
                || student_niveau.getSelectionModel().getSelectedItem().isEmpty()
                || student_course.getSelectionModel().getSelectedItem().isEmpty()
                || student_section.getSelectionModel().getSelectedItem().isEmpty()
                || student_birthDate.getValue() == null
                || student_semester.getSelectionModel().getSelectedItem().isEmpty()
                || student_gender.getSelectionModel().getSelectedItem().isEmpty()
                || student_emailPa.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields.");
        } else {
            connect = Database.connectDB();

            String checkStudentNum = "SELECT * FROM student WHERE student_id = '"
                    + student_number.getText() + "'";

            try {
                prepare = connect.prepareStatement(checkStudentNum);
                result = prepare.executeQuery();

                if (result.next()) {
                    alert.errorMessage("Student Number: " + student_number.getText() + " is already taken");
                } else {
                    String insertData = "INSERT INTO student "
                            + "(student_id, full_name, gender, birth_date, niveau, age, course, section, semester, emailPa , date_insert) "
                            + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    SimpleDateFormat format = new SimpleDateFormat("yyyy");
                    String getYear = format.format(date);
                    String studentNum = getYear + "0000";
                    int sNum = Integer.parseInt(studentNum) + studentIDGenerator();




                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(sNum));
                    //prepare.setString(1, student_number.getText());
                    prepare.setString(2, student_name.getText());
                    prepare.setString(3, student_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(4, String.valueOf(student_birthDate.getValue()));
                    prepare.setString(5, student_niveau.getSelectionModel().getSelectedItem());
                    prepare.setString(6, String.valueOf(getAge));
                    prepare.setString(7, student_course.getSelectionModel().getSelectedItem());
                    prepare.setString(8, student_section.getSelectionModel().getSelectedItem());
                    prepare.setString(9, student_semester.getSelectionModel().getSelectedItem());
                    prepare.setString(10, student_emailPa.getText());
                    prepare.setString(11, String.valueOf(sqlDate));
                    //Date date = new Date();
                    //java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    //prepare.setString(11, String.valueOf(sqlDate));


                    prepare.executeUpdate();

                    String Data = "INSERT INTO users (email ,username, password, role, student_id, date) "
                            + "VALUES(?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(Data);
                    prepare.setString(1, student_emailPa.getText());
                    prepare.setString(2, student_name.getText());
                    prepare.setString(3, student_name.getText());
                    prepare.setString(4, "student");
                    prepare.setString(5, String.valueOf(sNum));
                    prepare.setString(6, String.valueOf(sqlDate));

                    prepare.executeUpdate();
                    alert.successMessage("Added Successfully!");

                    clearFields();
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















    public void updateBtn() {
        if (student_number.getText().isEmpty()
                || student_name.getText().isEmpty()
                || (student_niveau.getSelectionModel().getSelectedItem().isEmpty())
                || (student_course.getSelectionModel().getSelectedItem().isEmpty())
                || (student_section.getSelectionModel().getSelectedItem().isEmpty())
                || student_birthDate.getValue() == null
                || ( student_semester.getSelectionModel().getSelectedItem().isEmpty())
                || (student_gender.getSelectionModel().getSelectedItem().isEmpty())
                || student_emailPa.getText().isEmpty()) {

            alert.errorMessage("Please fill all blank fields.");
        } else {
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());


            if (alert.confirmMessage("Are you sure you want to Update Student ID: "
                    + student_number.getText())) {

                String updateData = "UPDATE student SET "

                        + "full_name = '" + student_name.getText() + "', "
                        + "birth_date = '" + student_birthDate.getValue().toString() + "', "
                        + "age = '" + getAge + "', "
                        + "niveau = '" + student_niveau.getSelectionModel().getSelectedItem() + "', "
                        + "gender = '" + student_gender.getSelectionModel().getSelectedItem() + "', "
                        + "course = '" + student_course.getSelectionModel().getSelectedItem() + "', "
                        + "semester = '" + student_semester.getSelectionModel().getSelectedItem() + "', "
                        + "section = '" + student_section.getSelectionModel().getSelectedItem() + "', "
                        + "emailPa = '" + student_emailPa.getText() + "', "
                        + "date_update = '" + String.valueOf(sqlDate) + "' "
                        + "WHERE student_id = '" + student_number.getText() + "'";



                try {


                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();

                    alert.successMessage("Updated Successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                alert.errorMessage("Cancelled");
            }

        }

    }

    public void clearFields() {
        displayStudentNumber();

        student_name.clear();
        student_birthDate.setValue(null);
        student_niveau.getSelectionModel().clearSelection();
        student_course.getSelectionModel().clearSelection();
        student_gender.getSelectionModel().clearSelection();
        student_section.getSelectionModel().clearSelection();
        student_emailPa.clear();


    }

    private int getAge = 0;

    public void countAge() {
        if (student_birthDate.getValue() != null) {
            LocalDate birthDate = student_birthDate.getValue();
            int age = Period.between(birthDate, LocalDate.now()).getYears();

            getAge = age;

            System.out.println(getAge);
        }
    }



    public void displayStudentNumber() {
        FXMLDocumentController control = new FXMLDocumentController();

        int getnumber = control.studentIDGenerator();

        Date date = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy");

        String getyear = format.format(date) + "0000";

        int getStudentNum = Integer.parseInt(getyear) + getnumber;

        student_number.setText(String.valueOf(getStudentNum));

    }

    public void niveauList() {
        List<String> listY = new ArrayList<>();

        for (String data : ListData.niveau) {
            listY.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listY);
        student_niveau.setItems(listData);
    }

    public void courseList() {


        String sql = "SELECT * FROM course WHERE date_delete IS NULL";

        connect = Database.connectDB();

        try {
            ObservableList listData = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                listData.add(result.getString("course"));
            }
            student_course.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }




    public void setFields() {
        try {
            if (ListData.temp_studentNumber != null) {
                String sql = "SELECT * FROM student WHERE student_id = '"
                        + ListData.temp_studentNumber + "'";
                connect = Database.connectDB();

                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                if (result.next()) {

                    if (result.getString("full_name") != null) {
                        student_number.setText(ListData.temp_studentNumber);
                        student_name.setText(result.getString("full_name"));
                        student_birthDate.setValue(LocalDate.parse(result.getString("birth_date")));
                        student_niveau.getSelectionModel().select(result.getString("year"));
                        student_course.getSelectionModel().select(result.getString("course"));
                        student_section.getSelectionModel().select(result.getString("section"));
                        student_gender.getSelectionModel().select(result.getString("gender"));
                        student_semester.getSelectionModel().select(result.getString("semester"));
                        student_emailPa.setText(result.getString("emailPa"));

                    } else {
                        student_number.setText(ListData.temp_studentNumber);

                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sectionList() {
        List<String> listS = new ArrayList<>();

        for (String data : ListData.section) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        student_section.setItems(listData);
    }



    public void semesterList() {
        List<String> listS = new ArrayList<>();

        for (String data : ListData.semester) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        student_semester.setItems(listData);
    }

    public void genderList() {
        List<String> listG = new ArrayList<>();

        for (String data : ListData.gender) {
            listG.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        student_gender.setItems(listData);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        niveauList();
        courseList();
        sectionList();

        semesterList();
        genderList();

        displayStudentNumber();

        setFields();
    }

}