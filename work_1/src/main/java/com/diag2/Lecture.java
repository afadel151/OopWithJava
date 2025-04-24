package com.diag2;

import java.util.Date;

public class Lecture {
    private static int idCounter = 0;
    private int id;
    private Livre livre;
    private Date dateEmprunt;
    private Date dateRetour;

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

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public Lecture(Livre livre, java.util.Date dateEmprunt, java.util.Date dateRetour) {
        this.id = idCounter;
        this.livre = livre;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        idCounter++;
    }

    public Lecture() {
        this.id = idCounter;
        this.livre = new Livre();
        this.dateEmprunt = new Date();
        this.dateRetour = new Date();
        idCounter++;
    }
}
