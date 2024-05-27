package com.college.collegemang;


import java.sql.Date;

/**
 *
 * @author WINDOWS 10
 */
public class SubjectData {

    private Integer id;
    private String num_semaine;
    private String full_name;
    private String course;

    private String estJustifie;
    private Date dateInsert;
    private Date dateUpdate;
    private Date dateDelete;

    public SubjectData(Integer id, String num_semaine, String full_name, String course, String estJustifie, Date dateInsert, Date dateUpdate, Date dateDelete) {
        this.id = id;
        this.num_semaine = num_semaine;
        this.full_name = full_name;
        this.course = course;
        this.estJustifie = estJustifie;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.dateDelete = dateDelete;
    }

    public String getNum_semaine() {
        return num_semaine;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getEstJustifie() {
        return estJustifie;
    }

    public Integer getId() {
        return id;
    }


    public String getCourse() {
        return course;
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
