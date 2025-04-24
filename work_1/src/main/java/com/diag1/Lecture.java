package com.diag1;

public class Lecture {
    private static int idCounter = 0;
    private int id;
    private Livre livre;
    private Lecteur lecteur;
    private java.util.Date dateEmprunt;
    private java.util.Date dateRetour;

    public void setId(int id) {
        if (id < idCounter) {
            throw new IllegalArgumentException("Id must be greater than or equal to " + idCounter); 
        }else {

            for (int i = 0; i < idCounter; i++) {
                if (i == id) {
                    throw new IllegalArgumentException("Id already exists: " + id);
                }
            }
            this.id = id;
        }
    }

    public int getId() {
        return id;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }

    public java.util.Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(java.util.Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public java.util.Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(java.util.Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Lecture(Lecteur lect,Livre livre, java.util.Date dateEmprunt, java.util.Date dateRetour) {
        this.id = idCounter;
        this.livre = livre;
        this.lecteur = lect; 
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        idCounter++;
    }
}
