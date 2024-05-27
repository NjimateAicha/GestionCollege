package com.college.collegemang;



import java.sql.Date;

/**
 *
 * @author WINDOWS 10
 */
public class ChangementData {

    private  int iddemande;
    private String name;
    private String massar;
    private String classeSouh;
    private String Justification;

    private Date dateInsert;
    private Date dateDelete;


    public ChangementData(int iddemande, String name, String massar, String classeSouh, String justification, Date dateInsert, Date dateDelete) {
        this.iddemande = iddemande;
        this.name = name;
        this.massar = massar;
        this.classeSouh = classeSouh;
        Justification = justification;

        this.dateInsert = dateInsert;
        this.dateDelete = dateDelete;
    }


    public ChangementData(String name, String massar, String classeSouh, String justification) {
        this.name = name;
        this.massar = massar;
        this.classeSouh = classeSouh;
        Justification = justification;
    }

    public int getIddemande() {
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

    public Date getDateDelete() {
        return dateDelete;
    }
}



