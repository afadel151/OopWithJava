package com.diag1;

public class Main {
    public static void main(String[] args) {
        Livre livre1 = new Livre("L001", "Les Misérables", 1862);
        Livre livre2 = new Livre("L002", "1984", 1949);
        Livre livre3 = new Livre("L003", "Le Petit Prince", 1943);
        Lecteur lecteur1 = new Lecteur();
        lecteur1.setId(1);
        lecteur1.setNom("Dupont");
        lecteur1.setPrenom("Jean");
        lecteur1.setAdresse("123 Rue de Paris");
        Lecteur lecteur2 = new Lecteur();
        lecteur2.setId(2);
        lecteur2.setNom("Martin");
        lecteur2.setPrenom("Sophie");
        lecteur2.setAdresse("456 Avenue de Lyon");
        livre1.setLecteurs(new Lecteur[] { lecteur1, lecteur2 });
        livre2.setLecteurs(new Lecteur[] { lecteur1 });
        livre3.setLecteurs(new Lecteur[] {}); 


    }
}