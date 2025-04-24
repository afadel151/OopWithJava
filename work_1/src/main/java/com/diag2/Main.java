package com.diag2;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Livre livre1 = new Livre("L001", "Les Misérables", 1862, null);
        Livre livre2 = new Livre("L002", "1984", 1949, null);

        Lecteur lecteur1 = new Lecteur(1, "Jean", "Dupont", "123 Rue de Paris");
        Lecteur lecteur2 = new Lecteur(2, "Sophie", "Martin", "456 Avenue de Lyon");


        System.out.println("=== Test : Emprunt de livre ===");
        lecteur1.Lire(livre1);
        System.out.println("Livre 1 disponible ? " + livre1.isDisponible()); 

        lecteur2.Lire(livre1); 

        System.out.println("Lectures de Jean Dupont :");
        for (Lecture lecture : lecteur1.getLectures()) {
            System.out.println(" - " + lecture.getLivre().getIntitule() + " emprunté le " + lecture.getDateEmprunt());
        }
        System.out.println("=== Test : Disponibilité d'un livre à une date ===");
        Date date = new Date();
        System.out.println("Livre 2 disponible à la date " + date + " ? " + livre2.estDisponible(date)); 
    }
}
