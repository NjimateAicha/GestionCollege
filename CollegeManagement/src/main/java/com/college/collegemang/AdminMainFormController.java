package com.college.collegemang;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author WINDOWS 10
 */
public class AdminMainFormController  {

    public Button logout_btn;
    @FXML
    private Label greet_username;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button addStudent_btn;

    @FXML
    private Button addTeacher_btn;

    @FXML
    private Button addCourse_btn;

    @FXML
    private Button addSubject_btn;



    @FXML
    private AnchorPane addStudent_form;

    @FXML
    private AnchorPane addTeacher_form;

    @FXML
    private TableView<StudentData> addStudent_tableView;


    @FXML
    private TableColumn<StudentData, String> addStudent_col_studentNumber;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_name;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_niveau;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_course;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_section;

    @FXML
    private TableColumn<StudentData, String> addStudent_col_emailPa;


    @FXML
    private TableColumn<StudentData, String> addStudent_col_dateInsert;


    @FXML
    private Button addStudent_deleteBtn;

    @FXML
    private Button addStudent_updateBtn;

    @FXML
    private Button addStudent_addBtn;

    @FXML
    private TableView<TeacherData> addTeacher_tableView;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_teacherID;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_name;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_gender;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_yearExperience;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_experience;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_department;

    @FXML
    private TableColumn<TeacherData, String> addTeacher_col_dateInsert;



    @FXML
    private TextField addTeacher_teacherID;

    @FXML
    private TextField addTeacher_fullName;

    @FXML
    private ComboBox<String> addTeacher_gender;

    @FXML
    private ComboBox<String> addTeacher_experienceYear;

    @FXML
    private TextField addTeacher_experience;

    @FXML
    private TextField addTeacher_department;







    @FXML
    private Button addTeacher_addBtn;

    @FXML
    private Button addTeacher_updateBtn;

    @FXML
    private Button addTeacher_clearBtn;

    @FXML
    private Button addTeacher_deleteBtn;

    @FXML
    private TextField addCourse_course;

    @FXML
    private ComboBox<String> addCourse_department;


    @FXML
    private ComboBox<String> addCourse_Teacher;


    @FXML
    private TextField addCourse_Salle;
    @FXML
    private TextField addCourse_StartTime;
    @FXML
    private TextField addCourse_EndTime;

    @FXML
    private TextField addCourse_Jour;



    @FXML
    private Button addCourse_addBtn;

    @FXML
    private Button addCourse_updateBtn;

    @FXML
    private Button addCourse_clearBtn;

    @FXML
    private Button addCourse_deleteBtn;

    @FXML
    private TableView<CourseData> addCourse_tableView;

    @FXML
    private TableColumn<CourseData, String> addCourse_col_course;



    @FXML
    private TableColumn<CourseData, String> addCourse_col_department;
    @FXML
    private TableColumn<CourseData, String> addCourse_col_Salle;
    @FXML
    private TableColumn<CourseData, String> addCourse_col_StartTime;   
    @FXML
    private TableColumn<CourseData, String> addCourse_col_EndTime;
    @FXML
    private TableColumn<CourseData, String> addCourse_col_Jour;
    @FXML
    private TableColumn<CourseData, String> addCourse_col_teacher;

    

    @FXML
    private TableColumn<CourseData, String> addCourse_col_dateInsert;


    @FXML
    private AnchorPane addCourse_form;

    @FXML
    private AnchorPane addSubject_form;

    @FXML
    private TextField addSubject_num_semaine;

    @FXML
    private TextField addSubject_fullName;

    @FXML
    private ComboBox<String> addSubject_course;
    @FXML
    private TextField addSubject_estJustifier;





    @FXML
    private TableView<SubjectData> addSubject_tableView;

    @FXML
    private TableColumn<SubjectData, String> addSubject_col_num_semaine;

    @FXML
    private TableColumn<SubjectData, String> addSubject_col_fullName;

    @FXML
    private TableColumn<SubjectData, String> addSubject_col_course;

    @FXML
    private TableColumn<SubjectData, String> addSubject_col_estJustifier;



    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dashboard_TS;

    @FXML
    private Label dashboard_TT;

    @FXML
    private Label dashboard_SRT;

    @FXML
    private Label dashboard_TI;

    @FXML
    private AreaChart<?, ?> dashboard_chart_DS;

    @FXML
    private BarChart<?, ?> dashboard_chart_DT;



    // DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    @FXML
    private AnchorPane addDemande_form;

    @FXML
    private TableView<DemandeData> addDemande_tableView;
    @FXML
    private TableColumn<CourseData, String> addDemande_col_iddemande;
    @FXML
    private TableColumn<CourseData, String> addDemande_col_name;
    @FXML
    private TableColumn<CourseData, String> addDemande_col_massar;
    @FXML
    private TableColumn<CourseData, String> addDemande_col_Justification;
    @FXML
    private TableColumn<CourseData, String> addDemande_col_classeSouh;
    @FXML
    private TableColumn<CourseData, String> addDemande_col_dateInsert;




    @FXML
    private Button addDemande_btn;


    private AlertMessage alert = new AlertMessage();


    public void dashboardDisplayTS() {
        String sql = "SELECT COUNT(id) FROM student WHERE date_delete IS NULL";
        connect = Database.connectDB();
        int tempTS = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempTS = result.getInt("COUNT(id)");
            }
            dashboard_TS.setText("" + tempTS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardDisplayTT() {
        String sql = "SELECT COUNT(id) FROM teacher WHERE date_delete IS NULL";
        connect = Database.connectDB();
        int tempTT = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempTT = result.getInt("COUNT(id)");
            }
            dashboard_TT.setText(String.valueOf(tempTT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardDisplaySRT() {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String sql = "SELECT COUNT(id) FROM student WHERE date_delete IS NULL AND date_insert = '"
                + sqlDate + "'";
        connect = Database.connectDB();
        int tempSRT = 0;
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempSRT = result.getInt("COUNT(id)");

                dashboard_SRT.setText("" + tempSRT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void dashboardDSChart() {

        dashboard_chart_DS.getData().clear();

        String sql = "SELECT date_insert, COUNT(id) FROM student WHERE date_delete IS NULL GROUP BY TIMESTAMP(date_insert) ASC LIMIT 9";

        connect = Database.connectDB();

        try {
            XYChart.Series chart = new XYChart.Series<>();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }

            dashboard_chart_DS.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardDTChart() {

        dashboard_chart_DT.getData().clear();

        String sql = "SELECT date_insert, COUNT(id) FROM teacher WHERE date_delete IS NULL GROUP BY TIMESTAMP(date_insert) ASC LIMIT 5";

        connect = Database.connectDB();

        try {
            XYChart.Series chart = new XYChart.Series<>();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }

            dashboard_chart_DT.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ObservableList<StudentData> addStudentGetData() {

        ObservableList<StudentData> listData = FXCollections.observableArrayList();
        String selectData = "SELECT * FROM student WHERE date_delete IS NULL";

        connect = Database.connectDB();

        StudentData sData = null;

        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            while (result.next()) {
//


                sData = new StudentData(result.getInt("id"),
                        result.getString("student_id"),
                        result.getString("full_name"),
                        result.getString("niveau"),
                        result.getString("course"),
                        result.getString("section"),
                        result.getString("semester"),
                        result.getDate("date_insert"),
                        result.getString("emailPa"));




                listData.add(sData);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<StudentData> addStudentListData;

    public void addStudentDisplayData() {
        addStudentListData = addStudentGetData();

        addStudent_col_studentNumber.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        addStudent_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        addStudent_col_niveau.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        addStudent_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addStudent_col_section.setCellValueFactory(new PropertyValueFactory<>("section"));
        addStudent_col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));
        addStudent_col_emailPa.setCellValueFactory(new PropertyValueFactory<>("emailPa"));



        addStudent_tableView.setItems(addStudentListData);
    }

    public void addStudentAddBtn() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Add Student");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addStudentUpdateBtn() {

        StudentData sData = addStudent_tableView.getSelectionModel().getSelectedItem();
        int num = addStudent_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            alert.errorMessage("Please select the item first");
            return;
        } else {
            ListData.temp_studentNumber = sData.getStudentID();
            ListData.temp_studentName = sData.getFullName();
            ListData.temp_studentBirthDate = sData.getBirthDate();
            ListData.temp_studentNiveau = sData.getNiveau();
            ListData.temp_studentCourse = sData.getCourse();
            ListData.temp_studentGender = sData.getGender();
            ListData.temp_studentSemester = sData.getSemester();
            ListData.temp_studentSection = sData.getSection();
            ListData.temp_studentEmailPa= sData.getEmailPa();


            try {
                Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
                Stage stage = new Stage();

                stage.setTitle("Update Student");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void addStudentDeleteBtn() {

        StudentData sData = addStudent_tableView.getSelectionModel().getSelectedItem();
        int num = addStudent_tableView.getSelectionModel().getSelectedIndex();

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        if ((num - 1) < -1) {
            alert.errorMessage("Please select item first");
            return;
        } else {
            if (alert.confirmMessage("Are you sure you want to Delete Student ID: "
                    + sData.getStudentID() + "?")) {
                String deleteData = "UPDATE student SET date_delete = ? WHERE student_id = ?";
                connect = Database.connectDB();

                try {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.setString(1, String.valueOf(sqlDate));
                    prepare.setString(2, sData.getStudentID());
                    prepare.executeUpdate();
                    alert.successMessage("Deleted successfully!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.errorMessage("Cancelled.");
            }
        }
        addStudentDisplayData();
    }

    public ObservableList<TeacherData> addTeacherGetData() {

        ObservableList<TeacherData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM teacher WHERE date_delete IS NULL";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            TeacherData tData;

            while (result.next()) {
//
                tData = new TeacherData(
                        result.getInt("id"),
                        result.getString("teacher_id"),
                        result.getString("full_name"),
                        result.getString("gender"),
                        result.getString("year_experience"),
                        result.getString("experience"),
                        result.getString("department"),
                        result.getDate("date_insert"),
                        result.getDate("date_update"),
                        result.getDate("date_delete")
                );

                listData.add(tData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<TeacherData> addTeacherListData;

    public void addTeacherDisplayData() {
        addTeacherListData = addTeacherGetData();

        addTeacher_col_teacherID.setCellValueFactory(new PropertyValueFactory<>("teacherID"));
        addTeacher_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        addTeacher_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addTeacher_col_yearExperience.setCellValueFactory(new PropertyValueFactory<>("yearExperience"));
        addTeacher_col_experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        addTeacher_col_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        addTeacher_col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));


        addTeacher_tableView.setItems(addTeacherListData);

    }

    public void addTeacherSelectItems() {

        TeacherData tData = addTeacher_tableView.getSelectionModel().getSelectedItem();
        int num = addTeacher_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addTeacher_teacherID.setText(tData.getTeacherID());
        addTeacher_fullName.setText(tData.getFullName());
        addTeacher_gender.getSelectionModel().select(tData.getGender());
        addTeacher_experienceYear.getSelectionModel().select(tData.getYearExperience());
        addTeacher_experience.setText(tData.getExperience());
        addTeacher_department.setText(tData.getFullName());
      //  addTeacher_department.getSelectionModel().select(tData.getDepartment());

    }

    public void addTeacherGenderList() {

        List<String> listG = new ArrayList<>();

        for (String data : ListData.gender) {
            listG.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listG);
        addTeacher_gender.setItems(listData);
    }

    public void addTeacherEYList() {

        List<String> listEY = new ArrayList<>();

        for (String data : ListData.yearExperience) {
            listEY.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listEY);
        addTeacher_experienceYear.setItems(listData);
    }

    public void addTeacherSSList() {

        List<String> listSS = new ArrayList<>();


        ObservableList listData = FXCollections.observableArrayList(listSS);


    }





    private String teacherID;

    public void generateTeacherID() {

        String sql = "SELECT MAX(id) FROM teacher";

        connect = Database.connectDB();
        String temp_teacherID = "TID-";
        int temp_count = 0;

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                temp_count = result.getInt("MAX(id)");
            }

            if (temp_count == 0) {
                temp_count += 1;
                teacherID = temp_teacherID + temp_count;
            } else {
                teacherID = temp_teacherID + (temp_count + 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addTeacherDisplayTeacherID() {
        generateTeacherID();
        addTeacher_teacherID.setText(teacherID);
    }

    public void addTeacherAddBtn() {

        if (addTeacher_teacherID.getText().isEmpty()
                || addTeacher_fullName.getText().isEmpty()
                || addTeacher_gender.getSelectionModel().getSelectedItem().isEmpty()
                || addTeacher_experience.getText().isEmpty()
                || addTeacher_experienceYear.getSelectionModel().getSelectedItem().isEmpty()
                || addTeacher_department.getText().isEmpty())
               {
            alert.errorMessage("Please fill all blank fields");
        } else {

            String insertData = "INSERT INTO teacher "
                    + "(teacher_id, full_name, gender, year_experience, experience"
                    + ", department, date_insert) "
                    + "VALUES(?,?,?,?,?,?,?)";

            connect = Database.connectDB();

            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());


            try {
                prepare = connect.prepareStatement(insertData);
                prepare.setString(1, addTeacher_teacherID.getText());
                prepare.setString(2, addTeacher_fullName.getText());
                prepare.setString(3, addTeacher_gender.getSelectionModel().getSelectedItem());
                prepare.setString(4, addTeacher_experienceYear.getSelectionModel().getSelectedItem());
                prepare.setString(5, addTeacher_experience.getText());
                prepare.setString(6, addTeacher_department.getText());

                prepare.setString(7, String.valueOf(sqlDate));


                prepare.executeUpdate();

                // Mettre à jour la TableView après l'insertion
                addTeacherDisplayData();
                addTeacherClearBtn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addTeacherUpdateBtn() {

        if (addTeacher_teacherID.getText().isEmpty()
                || addTeacher_fullName.getText().isEmpty()
                || addTeacher_gender.getSelectionModel().getSelectedItem().isEmpty()
                || addTeacher_experience.getText().isEmpty()
                || addTeacher_experienceYear.getSelectionModel().getSelectedItem().isEmpty()
                || addTeacher_department.getText().isEmpty()
               ) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            if (alert.confirmMessage("Are you sure you want to Update Teacher ID: "
                    + addTeacher_teacherID.getText() + "?")) {


                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String updateData = "UPDATE teacher SET full_name = '"
                        + addTeacher_fullName.getText() + "', gender = '"
                        + addTeacher_gender.getSelectionModel().getSelectedItem() + "', experience = '"
                        + addTeacher_experience.getText() + "', year_experience = '"
                        + addTeacher_experienceYear.getSelectionModel().getSelectedItem() + "', department = '"
                        + addTeacher_department.getText() + "'"
                        + "WHERE teacher_id = '"
                        + addTeacher_teacherID.getText() + "'";

                connect = Database.connectDB();

                try {
                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();

                    addTeacherDisplayData();


                    alert.successMessage("Updated Successfully!");

                    addTeacherClearBtn();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.errorMessage("Cancelled.");
            }
        }
    }

    public void addTeacherDeleteBtn() {

        if (addTeacher_teacherID.getText().isEmpty()
                ) {
            alert.errorMessage("Please select the item first");
        } else {

            if (alert.confirmMessage("Are you sure you want to Delete Teacher ID: "
                    + addTeacher_teacherID.getText() + "?")) {
                String deleteData = "UPDATE teacher SET date_delete = ? WHERE teacher_id = ?";
                connect = Database.connectDB();

                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                try {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.setString(1, "" + sqlDate);
                    prepare.setString(2, addTeacher_teacherID.getText());

                    prepare.executeUpdate();

                    addTeacherDisplayData();

                    alert.successMessage("Deleted Successfully!");

                    addTeacherClearBtn();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.errorMessage("Cancelled");
            }
        }
    }

    public void addTeacherClearBtn() {
        addTeacherDisplayTeacherID();
        addTeacher_fullName.clear();
        addTeacher_gender.getSelectionModel().clearSelection();
        addTeacher_experienceYear.getSelectionModel().clearSelection();
        addTeacher_experience.clear();
        addTeacher_department.clear();

    }


    public ObservableList<CourseData> addCourseGetData() {
        ObservableList<CourseData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM course WHERE date_delete IS NULL";
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            CourseData cData;

            while (result.next()) {
                cData = new CourseData(
                        result.getInt("id"),
                        result.getString("course"),
                        result.getString("department"),
                        result.getString("Salle"),
                        result.getInt("StartTime"),
                        result.getInt("EndTime"),
                        result.getString("Jour"),
                        result.getString("teacher_id"), // Pass teacher_id before full_name
                        result.getString("full_name"),
                        result.getDate("date_insert"),
                        result.getDate("date_update"),
                        result.getDate("date_delete"));


                listData.add(cData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }






    private ObservableList<CourseData> addCourseListData;


    public ObservableList<String> getTeacherNames() {
        ObservableList<String> teacherNames = FXCollections.observableArrayList();

        String sql = "SELECT fullName FROM teacher WHERE date_delete IS NULL";

        try {
            connect = Database.connectDB();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                teacherNames.add(result.getString("fullName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return teacherNames;
    }


    public void addCourseDisplayData() {
        addCourseListData = addCourseGetData();

        addCourse_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addCourse_col_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        addCourse_col_Salle.setCellValueFactory(new PropertyValueFactory<>("Salle"));
        addCourse_col_StartTime.setCellValueFactory(new PropertyValueFactory<>("StartTime"));
        addCourse_col_EndTime.setCellValueFactory(new PropertyValueFactory<>("EndTime"));
        addCourse_col_Jour.setCellValueFactory(new PropertyValueFactory<>("Jour"));
        //  addCourse_col_teacher.setCellValueFactory(new PropertyValueFactory<>("full_name"));

        addCourse_col_teacher.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());

        //addCourse_col_teacher.setCellValueFactory(cellData -> new SimpleStringProperty(getTeacherNameById(cellData.getValue().getTeacher_id())));


        // addCourse_col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));
        addCourse_tableView.setItems(addCourseListData);



    }

    private int courseID = 0;


    private String getTeacherNameById(String teacherId) {
        String fullName = "";
        String sql = "SELECT fullName FROM teacher WHERE teacher_id = ? AND date_delete IS NULL";

        try (PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
            preparedStatement.setString(1, teacherId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    fullName = resultSet.getString("fullName");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fullName;
    }

    public void addCourseDepartmentList() {
        String sql = "SELECT * FROM teacher WHERE date_delete IS NULL";
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            ObservableList<String> listData = FXCollections.observableArrayList();


         //   ObservableList listData = FXCollections.observableArrayList(); // Mettez à jour le type ici

            while (result.next()) {
                listData.add(result.getString("department"));
            }
            addCourse_department.setItems(listData);
            //System.out.println("Data in ComboBox: " + addCourse_department.getItems());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addCourseTeacherList() {
        String sql = "SELECT * FROM teacher WHERE date_delete IS NULL";
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            ObservableList<String> listData = FXCollections.observableArrayList();


            //   ObservableList listData = FXCollections.observableArrayList(); // Mettez à jour le type ici

            while (result.next()) {
                listData.add(result.getString("full_name"));
            }
            addCourse_Teacher.setItems(listData);
            //System.out.println("Data in ComboBox: " + addCourse_Teacher.getItems());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public void addCourseSelectItem() {
        CourseData cData = addCourse_tableView.getSelectionModel().getSelectedItem();
        int num = addCourse_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addCourse_course.setText(cData.getCourse());
        addCourse_department.getSelectionModel().select(cData.getDepartment());
        addCourse_Salle.setText(cData.getSalle());
        addCourse_StartTime.setText(String.valueOf(cData.getStartTime()));
        addCourse_EndTime.setText(String.valueOf(cData.getEndTime()));
        addCourse_Jour.setText(cData.getJour());
        addCourse_Teacher.getSelectionModel().select(cData.getFull_name());
        courseID = cData.getId();
    }
    private String getTeacher_id() {
        String teacherName = addCourse_Teacher.getSelectionModel().getSelectedItem();
        String teacher_id = "";

        // Use the selected teacher's name to retrieve the corresponding teacher_id from the database
        String sql = "SELECT teacher_id FROM teacher WHERE full_name = ? AND date_delete IS NULL";

        try (PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
            preparedStatement.setString(1, teacherName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    teacher_id = resultSet.getString("teacher_id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return teacher_id;
    }

    public void addCourseAddBtn() {
        if (addCourse_course.getText().isEmpty()
                || addCourse_department.getSelectionModel().getSelectedItem().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            connect = Database.connectDB();

            String checkCourse = "SELECT * FROM course WHERE course = '"
                    + addCourse_course.getText() + "' AND date_delete IS NULL";
            try (Statement statement = connect.createStatement();
                 ResultSet result = statement.executeQuery(checkCourse)) {

                if (result.next()) {
                    alert.errorMessage(addCourse_course.getText() + " is already exist");
                } else {
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());


                    String insertData = "INSERT INTO course (course, department, Salle , StartTime ,EndTime, Jour ,teacher_id,full_name) "
                            + "VALUES(?,?,?,?,?,?,?,?)";
                    try (PreparedStatement prepare = connect.prepareStatement(insertData)) {
                        prepare.setString(1, addCourse_course.getText());
                        prepare.setString(2, addCourse_department.getSelectionModel().getSelectedItem());
                        prepare.setString(3, addCourse_Salle.getText());
                        prepare.setInt(4, Integer.parseInt(addCourse_StartTime.getText()));
                        prepare.setInt(5, Integer.parseInt(addCourse_EndTime.getText()));
                        prepare.setString(6, addCourse_Jour.getText());
                        prepare.setString(7, getTeacher_id());
                        prepare.setString(8, addCourse_Teacher.getSelectionModel().getSelectedItem());
                        prepare.executeUpdate();

                        String teacherName = addCourse_Teacher.getSelectionModel().getSelectedItem().trim();
                        if (addCourse_Teacher.getItems().stream().anyMatch(item ->
                                item.trim().equalsIgnoreCase(teacherName))) {
                            addCourse_Teacher.getItems().removeIf(item ->
                                    item.trim().equalsIgnoreCase(teacherName));
                        }

                        // Remove the teacher from the list

                        addCourseTeacherList();
                        addCourseDisplayData();
                        alert.successMessage("Added Successfully!");
                        addCourseClear();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addCourseUpdateBtn() {
        if (addCourse_course.getText().isEmpty()
                || addCourse_department.getSelectionModel().getSelectedItem().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            if (alert.confirmMessage("Are you sure you want to Update the course "
                    + addCourse_course.getText() + "?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                // Obtain the new ID of the teacher using the current name of the teacher
                //String newTeacherId = getTeacher_id(addCourse_Teacher.getSelectionModel().getSelectedItem());
                String newTeacherId = getTeacher_id();


                // Use the new teacher ID to update the course
                String updateData = "UPDATE course SET course = '"
                        + addCourse_course.getText() + "', department = '"
                        + addCourse_department.getSelectionModel().getSelectedItem() + "', Salle = '"
                        + addCourse_Salle.getText() + "', StartTime = "
                        + Integer.parseInt(addCourse_StartTime.getText()) + ", EndTime = "
                        + Integer.parseInt(addCourse_EndTime.getText()) + ", Jour = '"
                        + addCourse_Jour.getText() + "', teacher_id = '" + newTeacherId + "', full_name ='"
                        + addCourse_Teacher.getSelectionModel().getSelectedItem() + "', date_update = '"
                        + sqlDate + "' WHERE id = " + courseID;

                connect = Database.connectDB();

                try {
                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();

                    addCourseDisplayData();

                    alert.successMessage("Updated Successfully!");

                    addCourseClear();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.errorMessage("Cancelled");
            }
        }
    }


    public void addCourseDeleteBtn() {

        if (courseID == 0) {
            alert.errorMessage("Please select item first");
        } else {

            if (alert.confirmMessage("Are you sure you want to Delete Course "
                    + addCourse_course.getText() + "?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String deleteData = "UPDATE course SET date_delete = ? WHERE id = ?";
                connect = Database.connectDB();

                try {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.setString(1, String.valueOf(sqlDate));
                    prepare.setString(2, String.valueOf(courseID));

                    prepare.executeUpdate();


                    // Add the teacher back to the list
                    String teacherName = addCourse_Teacher.getSelectionModel().getSelectedItem();
                    addCourse_Teacher.getItems().add(teacherName);

                    addCourseDisplayData();

                    alert.successMessage("Updated Successfully!");

                    addCourseClear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void addCourseClear() {
        addCourse_course.clear();
        addCourse_department.getSelectionModel().getSelectedItem();
        addCourse_Salle.clear();
        addCourse_StartTime.clear();
        addCourse_EndTime.clear();
        addCourse_Jour.clear();
        addCourse_Teacher.getSelectionModel().getSelectedItem();
    }


    public ObservableList<SubjectData> addSubjectGetData() {

        ObservableList<SubjectData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM absence WHERE date_delete IS NULL";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            SubjectData sData;
//
            while (result.next()) {

                sData = new SubjectData(
                        result.getInt("id"),
                        result.getString("num_semaine"),
                        result.getString("full_name"),  // Utilisez "full_name" au lieu de "Fullname"
                        result.getString("course"),
                        result.getString("estJustifie"),  // Utilisez "estJustifie" au lieu de "estJustifier"
                        result.getDate("date_insert"),
                        result.getDate("date_update"),
                        result.getDate("date_delete")
                );


                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<SubjectData> addSubjectListData;

    public void addSubjectDisplayData() {


            addSubjectListData = addSubjectGetData();
        addSubject_col_num_semaine.setCellValueFactory(new PropertyValueFactory<>("num_semaine"));
        addSubject_col_fullName.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        addSubject_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addSubject_col_estJustifier.setCellValueFactory(new PropertyValueFactory<>("estJustifie"));


            addSubject_tableView.setItems(addSubjectListData);


        }




    private int subjectID = 0;

    public void addSubjectSelectItem() {
        SubjectData sData = addSubject_tableView.getSelectionModel().getSelectedItem();
        int num = addSubject_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        addSubject_num_semaine.setText(sData.getNum_semaine());
        addSubject_fullName.setText(sData.getFull_name());
        addSubject_course.getSelectionModel().select(sData.getCourse());
        addSubject_estJustifier.setText(sData.getEstJustifie());

        subjectID = sData.getId();
    }

    public void addSubjectAddBtn() {

        if (addSubject_num_semaine.getText().isEmpty()
                || addSubject_fullName.getText().isEmpty()
                || addSubject_course.getSelectionModel().getSelectedItem()==null
                || addSubject_estJustifier.getText().isEmpty()
              ) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            connect = Database.connectDB();
            String checkSubject = "SELECT * FROM absence WHERE num_semaine = '"
                    + addSubject_num_semaine.getText() + "' AND date_delete IS NULL";


            try {
                statement = connect.createStatement();
                result = statement.executeQuery(checkSubject);

                if (result.next()) {
                    alert.errorMessage(addSubject_num_semaine.getText() + " is already exist");
                } else {
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());


                    String insertData = "INSERT INTO absence "
                            + "(num_semaine, full_name, course, estJustifie) "
                            + "VALUES(?,?,?,?)";

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, addSubject_num_semaine.getText());
                    prepare.setString(2, addSubject_fullName.getText());
                    prepare.setString(3, addSubject_course.getSelectionModel().getSelectedItem());
                    prepare.setString(4, addSubject_estJustifier.getText());
                    //prepare.setString(5, String.valueOf(sqlDate));



                    prepare.executeUpdate();

                    addSubjectDisplayData();

                    alert.successMessage("Added Successfully!");

                    addSubjectClear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addSubjectUpdateBtn() {



        if (addSubject_num_semaine.getText().isEmpty()
                || addSubject_fullName.getText().isEmpty()
                || addSubject_course.getSelectionModel().getSelectedItem().isEmpty()
                || addSubject_estJustifier.getText().isEmpty()
               ) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            if (alert.confirmMessage("Are you sure you want to Update the num_semaine: "
                    + addSubject_num_semaine.getText() + "?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                String updateData = "UPDATE absence SET num_semaine = '"
                        + addSubject_num_semaine.getText() + "', full_name = '"
                        + addSubject_fullName.getText() + "', course = '"
                        + addSubject_course.getSelectionModel().getSelectedItem()+"' , estJustifier ='"
                        +addSubject_estJustifier.getText()
                        + "', date_update = '"
                        + sqlDate + "'"
                        + "WHERE id = " + subjectID;

                connect = Database.connectDB();

                try {
                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();

                    addSubjectDisplayData();

                    alert.successMessage("Updated Successfully!");

                    addSubjectClear();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert.errorMessage("Cancelled");
            }
        }
    }

    public void addSubjectDeleteBtn() {

        if (subjectID == 0) {
            alert.errorMessage("Please select item first");
        } else {

            if (alert.confirmMessage("Are you sure you want to Delete NumSemaine: "
                    + addSubject_num_semaine.getText() + "?")) {
                Date date = new Date();
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String deleteData = "UPDATE absence SET date_delete = ? WHERE id = ?";
                connect = Database.connectDB();

                try {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.setString(1, String.valueOf(sqlDate));
                    prepare.setString(2, String.valueOf(subjectID));

                    prepare.executeUpdate();

                    addSubjectDisplayData();

                    alert.successMessage("Deleted Successfully!");

                    addSubjectClear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void addSubjectClear() {
        addSubject_num_semaine.clear();
        addSubject_fullName.clear();
        addSubject_course.getSelectionModel().clearSelection();
        addSubject_estJustifier.clear();

    }



    public ObservableList<DemandeData> addDemandeGetData() {
        ObservableList<DemandeData> listData = FXCollections.observableArrayList();
        String selectData = "SELECT * FROM demande WHERE date_delete IS NULL";

        connect = Database.connectDB();

        DemandeData sData = null;

        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            while (result.next()) {
                sData = new DemandeData(
                        result.getInt("iddemande"),
                        result.getString("name"),
                        result.getString("massar"),
                        result.getString("classeSouh"),
                        result.getString("Justification"),
                        result.getDate("date_insert")
                );




                listData.add(sData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }


    private ObservableList<DemandeData> addDemandeListData;



        public void addDemandeDisplayData() {
            addDemandeListData = addDemandeGetData();
            // Affichez les données pour le débogage

            addDemande_col_iddemande.setCellValueFactory(new PropertyValueFactory<>("iddemande"));
            addDemande_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            addDemande_col_massar.setCellValueFactory(new PropertyValueFactory<>("massar"));
            addDemande_col_classeSouh.setCellValueFactory(new PropertyValueFactory<>("classeSouh"));
            addDemande_col_Justification.setCellValueFactory(new PropertyValueFactory<>("Justification"));
            addDemande_col_dateInsert.setCellValueFactory(new PropertyValueFactory<>("dateInsert"));

            addDemande_tableView.setItems(addDemandeListData);


    }




    public void addSubjectCourseList() {

        String sql = "SELECT * FROM course WHERE date_delete IS NULL";
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            ObservableList listData = FXCollections.observableArrayList();

            while (result.next()) {
                listData.add(result.getString("course"));
            }

            addSubject_course.setItems(listData);

        } catch (Exception e) {
            e.printStackTrace();
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

    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {

            dashboard_form.setVisible(true);
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(false);
            addDemande_form.setVisible(false);



            dashboardDisplayTS();
            dashboardDisplayTT();
            dashboardDisplaySRT();

            dashboardDSChart();
            dashboardDTChart();


        } else if (event.getSource() == addStudent_btn) {
            dashboard_form.setVisible(false);
            addStudent_form.setVisible(true);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(false);
            addDemande_form.setVisible(false);


            addStudentDisplayData();
        } else if (event.getSource() == addTeacher_btn) {
            dashboard_form.setVisible(false);
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(true);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(false);
            addDemande_form.setVisible(false);



            addTeacherDisplayData();
            addTeacherGenderList();
            addTeacherSSList();
            addTeacherEYList();
         //   addTeacherDepartmentList();

            addTeacherDisplayTeacherID();
        } else if (event.getSource() == addCourse_btn) {
            dashboard_form.setVisible(false);
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(true);
            addSubject_form.setVisible(false);
            addDemande_form.setVisible(false);

            addCourseDepartmentList();
            addCourseTeacherList();

            // Affichage des données de cours dans le tableau
            addCourseDisplayData();




        } else if (event.getSource() == addSubject_btn) {
            dashboard_form.setVisible(false);
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(true);
            addDemande_form.setVisible(false);


            addSubjectDisplayData();
            addSubjectCourseList();

        }
        else if (event.getSource() == addDemande_btn) {
            dashboard_form.setVisible(false);
            addStudent_form.setVisible(false);
            addTeacher_form.setVisible(false);
            addCourse_form.setVisible(false);
            addSubject_form.setVisible(false);
            addDemande_form.setVisible(true);


            addDemandeDisplayData();

    }

}


}