package app;


public class App 
{
    public static void main( String[] args )
    {
        Banque banque = new Banque("El baraka");
        Client client = new Client();
        client.setNom("Fadel");
        client.setPrenom("Akram");
        client.setAdresse("Sidi belabbes");
        client.setTelephone("0123456");
        Carte carte = new Carte(client, 0, "123456", 1234);
        client.setCarte(carte);
        Machine machine = new Machine(banque);
        client.introduireCarte(machine);
    }
}
