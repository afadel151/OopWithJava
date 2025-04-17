package com.diag1;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Livre {

    private String code;
    private String intitule;
    private int anneePublication;
    private List<Lecture> lectures;

    public boolean estLu() {
        if (lectures == null) {
            return false;
        }
        for (Lecture lecture : lectures) {
            if (lecture != null) {
                return true;
            }
        }
        return false;
    }

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

    public Lecteur[] getLecteurs() {
        if (lectures == null) {
            return null;
        }
        Lecteur[] lecteurs = new Lecteur[lectures.size()];
        for (int i = 0; i < lectures.size(); i++) {
            lecteurs[i] = lectures.get(i).getLecteur();
        }
        return lecteurs;
    }

    public void setLecteurs(Lecteur[] lecteurs) {
        if (lectures == null) {
            lectures = new ArrayList<>();
        }
        for (Lecteur lecteur : lecteurs) {
            Lecture lecture = new Lecture(lecteur,this, new Date(), null);
            lectures.add(lecture);
        }
    }

    public Livre(String code, String intitule, int anneePublication) {
        this.code = code;
        this.intitule = intitule;
        this.anneePublication = anneePublication;
    }

    public Livre() {
        this.code = "0000";
        this.intitule = "Inconnu";
        this.anneePublication = 0;
    }
}
