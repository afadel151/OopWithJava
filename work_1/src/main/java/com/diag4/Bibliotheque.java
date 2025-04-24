package com.diag4;

import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private int code;
    private String libelle;
    private String adresse;
    private List<Livre> livres;

    public Bibliotheque(int code, String libelle, String adresse) {
        this.code = code;
        this.libelle = libelle;
        this.adresse = adresse;
        this.livres = new ArrayList<>();
    }

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getCode() {
        return code;
    }

    //setters
    public void setCode(int code) {
        this.code = code;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }
    public void ajouterLivre(String code, String intitule, int anneePublication) {
        Livre livre = new Livre(code, intitule, anneePublication);
        livres.add(livre);
    }

    public void supprimerLivre(Livre livre) {
        livres.remove(livre);
    }

    public void supprimerLivre(String code) {
        for (int i = 0; i < livres.size(); i++) {
            if (livres.get(i).getCode().equals(code)) {
                livres.remove(i);
                break;
            }
        }
    }

}
