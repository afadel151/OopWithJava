package app;
import java.util.Scanner;
public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private Carte carte;
    public Client(String nom, String prenom, String adresse, String telephone,Carte carte) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.carte = carte;
    }
    public Client()
    {

    }
    public String getNom() {
        return nom;
    }
    public void setCarte(Carte carte)
    {
        this.carte= carte;
    }
    public Carte getCarte()
    {
        return this.carte;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
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

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void introduireCarte(Machine machine) {
        machine.setCarte(this.carte);
    }
    public int typeCode() {
        
        int code;
        try (Scanner scanner = new Scanner(System.in)) {
            code = scanner.nextInt();
        }
        return code;
    }
    public boolean demandeTicket()
    {
        String input;
        try (Scanner scanner = new Scanner(System.in)) {
            
            input = scanner.nextLine().trim().toLowerCase();
            while (!input.equals("y") && !input.equals("n")) {
                System.out.println("Entrée invalide. Veuillez taper 'y' pour oui ou 'n' pour non.");
                input = scanner.nextLine().trim().toLowerCase();
            }
        }
        return input.equals("y");

    }
    public void recupererCarte()
    {
        System.out.println("Client: Carte recuperee");
    }
    public void recupererBillets()
    {
        System.out.println("Client: Billets recuperee");
    }
    public void recupererTickets()
    {
        System.out.println("Client: Tickets recuperee");
    }
    
}
