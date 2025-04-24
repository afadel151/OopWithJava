package com.diag1;
public class Lecteur {

    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private Lecture[] lectures; 

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public Lecture[] getLectures() {
        return lectures;
    }
    public void setLectures(Lecture[] lectures) {
        this.lectures = lectures;
    }
}