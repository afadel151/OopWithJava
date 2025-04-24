package app;

import java.util.Scanner;

public class Machine {
    private Banque banque;
    public Machine(Banque banque){
        this.banque = banque;
    }
    public void setBanque(Banque banque)
    {
        this.banque = banque;
    }
    public Banque getBanque()
    {
        return this.banque;
    }
    public boolean verifyCard(Carte card) {
        return true;
    }

    public int requestCode(Carte card) {
        int code = card.getClient().typeCode();
        return code;
    }

    public void setCarte(Carte carte) {
        if (verifyCard(carte)) {
            System.out.println("Machine: Entrer le code de la carte : ");
            int code = requestCode(carte);
            if (code == carte.getCode()) {
                double soldeAutorisee = this.banque.autoriserSolde(carte);
                if (soldeAutorisee < 1000) {
                    System.out.println("Machine: Votre solde est inferieur a 1000DA");
                    ejecterCarte(carte);
                }
                proposerMontants(soldeAutorisee);
                try (Scanner scanner = new Scanner(System.in)) {
                    double solde = scanner.nextDouble();
                    if (solde <= soldeAutorisee) {
                        System.out.println("Machine: Voulez-vous avoir un ticket ? (y/n)");
                        if (demandeTicket(carte.getClient())) {
                            ejecterTickets(carte);
                        }
                        ejecterCarte(carte);
                        ejecterBillets(carte, solde);
                    } else {
                        System.out.println("Machine:Votre solde est inferieur a" + solde);
                        ejecterCarte(carte);

                    }
                }
            } else {
                System.out.println("Machine: Erreur lors de verification du code ");
                ejecterCarte(carte);
            }
        } else {
            System.out.println("Machine: Erreur lors de la verification de la carte");
            ejecterCarte(carte);

        }
    }

    public void proposerMontants(double solde) {
       
        for (double index = 1000; index < solde; index = index + 1000) {
            System.out.println("-" + index + "DA");
        }
    }

    public boolean demandeTicket(Client client) {
        return client.demandeTicket();
    }

    public void ejecterCarte(Carte carte) {
        carte.getClient().recupererCarte();
    }

    public void ejecterBillets(Carte carte, double montant) {
        carte.setSolde(carte.getSolde() - montant);
        carte.getClient().recupererBillets();
    }

    public void ejecterTickets(Carte carte) {
        carte.getClient().recupererTickets();
    }
}
