package com.college.collegemang;

import java.sql.Date;

public class DemandeData {


    private Integer iddemande;
    private String name;
    private String massar;
    private String classeSouh;

    private String Justification;

    private Date dateInsert;
    private Date dateUpdate;
    private Date dateDelete;


    public DemandeData(Integer iddemande, String name, String massar, String classeSouh, String justification, Date dateInsert, Date dateUpdate, Date dateDelete) {
        this.iddemande = iddemande;
        this.name = name;
        this.massar = massar;
        this.classeSouh = classeSouh;
        Justification = justification;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.dateDelete = dateDelete;
    }

    public DemandeData(Integer iddemande, String name, String massar, String classeSouh, String justification, Date dateInsert) {
        this.iddemande = iddemande;
        this.name = name;
        this.massar = massar;
        this.classeSouh = classeSouh;
        Justification = justification;
        this.dateInsert = dateInsert;
    }

    public Integer getIddemande() {
        return iddemande;
    }

    public String getName() {
        return name;
    }

    public String getMassar() {
        return massar;
    }

    public String getClasseSouh() {
        return classeSouh;
    }

    public String getJustification() {
        return Justification;
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
