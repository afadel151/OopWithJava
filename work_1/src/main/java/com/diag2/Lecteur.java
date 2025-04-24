package com.diag2;

public class Lecteur {

    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private Lecture[]  lectures;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id; 
    }
    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return this.prenom;
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
        return this.lectures;
    }
    public void setLectures(Lecture[] lectures) {
        this.lectures = lectures;
    }
    public Lecteur(int id, String nom, String prenom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
    public Lecteur() {
        this.id = 0;
        this.nom = "Inconnu";
        this.prenom = "Inconnu";
        this.adresse = "Inconnu";
        this.lectures = null;
    }
    public void Lire(Livre l) {
        if (l == null) {
            throw new IllegalArgumentException("Livre ne peut pas être null");
        }
        if (l.isDisponible()) {
            l.setDisponible(false);
            Lecture lecture = new Lecture(l, new java.util.Date(), null);
            if (lectures == null) {
                lectures = new Lecture[1];
                lectures[0] = lecture;
            } else {
                Lecture[] newLectures = new Lecture[lectures.length + 1];
                System.arraycopy(lectures, 0, newLectures, 0, lectures.length);
                newLectures[lectures.length] = lecture;
                lectures = newLectures;
            }
        } else {
            System.out.println("Le livre n'est pas disponible.");
        }
    }
        
}