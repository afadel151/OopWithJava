package com.diag3;
public class Livre {
    private Bibliotheque bibliotheque;
    private String code;
    private String intitule;
    private int anneePublication;
    private boolean disponibile;

    public Livre(String code, String intitule, int anneePublication, Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
        this.code = code;
        this.intitule = intitule;
        this.anneePublication = anneePublication;
        this.disponibile = true;
    }
    public Livre() {
        this.code = "0000";
        this.intitule = "Inconnu";
        this.anneePublication = 0;
        this.disponibile = true;
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
    public boolean isDisponible() {
        return disponibile;
    }
    public void setDisponible(boolean disponibile) {
        this.disponibile = disponibile;
    }
    public Bibliotheque getBibliotheque() {
        return bibliotheque;
    }
    public void setBibliotheque(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }
}
