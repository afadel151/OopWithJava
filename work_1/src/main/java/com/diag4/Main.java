package com.diag4;

public class Main {

    public static void main(String[] args) {
        // Création d'une bibliothèque
        Bibliotheque biblio = new Bibliotheque(1, "Bibliothèque Centrale", "1 Rue des Sciences");

        // Création de quelques livres
        // Livre livre1 = new Livre("Le Petit Prince", "Antoine de Saint-Exupéry");
        // Livre livre2 = new Livre("L'Étranger", "Albert Camus");

        // Ajout des livres à la bibliothèque
        // biblio.ajouterLivre(livre1);
        // biblio.ajouterLivre(livre2);

        // Affichage des livres disponibles dans la bibliothèque
        System.out.println("Livres dans la " + biblio.getLibelle() + " :");
        for (Livre l : biblio.getLivres()) {
            // System.out.println("- " + l.getTitre() + " par " + l.getAuteur());
        }
    }
}
