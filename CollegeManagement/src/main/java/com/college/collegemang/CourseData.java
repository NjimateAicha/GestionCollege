package com.college.collegemang;

import java.sql.Date;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author WINDOWS 10
 */
public class CourseData {

    private Integer id;
    private String course;
    private String department;



    private int  StartTime;

    private int  EndTime;

    private String Salle;
    private String Jour;
    private String teacher_id;
    private String full_name;
    private Date dateInsert;
    private Date dateUpdate;
    private Date dateDelete;

    private SimpleStringProperty fullNameProperty;

    public CourseData(Integer id, String course, String department, String Salle, int StartTime, int EndTime, String Jour, String teacher_id, String full_name, Date dateInsert, Date dateUpdate, Date dateDelete) {
        this.id = id;
        this.course = course;
        this.department = department;
        this.Salle = Salle;  // Correction du nom du paramètre ici
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.Jour = Jour;
        this.teacher_id = teacher_id;
        this.full_name = full_name;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.dateDelete = dateDelete;
        this.fullNameProperty = new SimpleStringProperty(full_name);
    }

    public CourseData(int id, String course, String department, String salle, int startTime, int endTime, String jour, String fullName, Date dateInsert, Date dateUpdate, Date dateDelete) {
    }


    public Integer getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public String getDepartment() {
        return department;
    }

    public Date getDateInsert() {
        return dateInsert;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public Date getDateDelete() {
        return dateDelete;
    }
    public int getStartTime() {
        return StartTime;
    }


    public int getEndTime() {
        return EndTime;
    }


    public String getSalle() {
        return Salle;
    }


    public String getTeacher_id() {
        return teacher_id;
    }


    public String getFull_name() {
        return full_name;
    }

    public String getJour() {
        return Jour;
    }

    public String getFullName() {
        return fullNameProperty.get();
    }

    public SimpleStringProperty fullNameProperty() {
        return fullNameProperty;
    }



}