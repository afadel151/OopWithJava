package app;

public class Banque {
    private String nom;
    public Banque(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public double autoriserSolde(Carte carte) {
        return carte.getSolde(); 
    }
}
