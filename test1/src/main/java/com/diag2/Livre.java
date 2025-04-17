package com.diag2;

import java.util.Date;

public class Livre {
    private String code;
    private String intitule;
    private int anneePublication;
    private boolean disponibile;
    private Lecture[] lectures;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getIntitule() {
        return intitule;
    }
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    public int getAnneePublication() {
        return anneePublication;
    }
    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }
    public Livre(String code, String intitule, int anneePublication,Lecture[] lectures) {
        this.code = code;
        this.intitule = intitule;
        this.anneePublication = anneePublication;
        this.disponibile = true;
        this.lectures = lectures;
    }
    public Livre() {
        this.code = "0000";
        this.intitule = "Inconnu";
        this.anneePublication = 0;
        this.disponibile = true;
        this.lectures = null;
    }
    @Override
    public String toString() {
        return "Livre [code=" + code + ", intitule=" + intitule + ", anneePublication=" + anneePublication + "]";
    }
    public boolean isDisponible() {
        return disponibile;
    }
    public void setDisponible(boolean disponibile) {
        this.disponibile = disponibile;
    }
    public boolean estDisponible(Date date) {
        if (lectures == null) {
            return true;
        }
        for (Lecture lecture : lectures) {
            if (lecture != null && lecture.getDateEmprunt().equals(date)) {
                return false;
            }
        }
        return true;    
    }

    public Lecture[] getLectures() {
        return lectures;
    }

    public void setLectures(Lecture[] lectures) {
        this.lectures = lectures;
    }
}
