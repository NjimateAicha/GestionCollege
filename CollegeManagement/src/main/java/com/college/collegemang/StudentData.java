package com.college.collegemang;
import java.sql.Date;

/**
 *
 * @author WINDOWS 10
 */
public class StudentData {

    private Integer id;
    private String studentID;
    private String full_name;
    private String gender;
    private Date birthDate;
    private String niveau;
    private String course;
    private String section;

    private String emailPa;

    private Date dateInsert;
    private Date dateUpdate;
    private Date dateDelete;

    private String semester;

    public StudentData(Integer id, String studentID, String full_name, String gender,
                       String niveau, String course, String section,String emailPa) {
        this.id = id;
        this.studentID = studentID;
        this.full_name = full_name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.niveau = niveau;
        this.course = course;
        this.section = section;
        this.emailPa = emailPa;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.dateDelete = dateDelete;

    }

    public StudentData(Integer id, String studentID, String full_name, String niveau, String course,
                       String section, String semester,  Date dateInsert,String emailPa) {
        this.id = id;
        this.studentID = studentID;
        this.full_name = full_name;
        this.niveau = niveau;
        this.course = course;
        this.section = section;
        this.semester = semester;

        this.dateInsert = dateInsert;
        this.emailPa=emailPa;

    }

    public StudentData(Integer id, String studentID, String full_name, String niveau, String course,
                       String section, String semester, String image,String emailPa,
                       Date dateUpdate) {
        this.id = id;
        this.studentID = studentID;
        this.full_name = full_name;
        this.niveau = niveau;
        this.course = course;
        this.section = section;
        this.semester = semester;
        this.emailPa = emailPa;
        this.dateUpdate = dateUpdate;

    }

    public StudentData(int id, String studentId, String full_name, String niveau, String course, String section, String semester, String emailPa, Date dateInsert) {
    }

    public Integer getId() {
        return id;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFullName() {
        return full_name;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public String getSection() {
        return section;
    }
    public String getEmailPa() {
        return emailPa;
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



}