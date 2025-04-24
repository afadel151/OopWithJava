package app;

public class Carte {
    private Client client;
    private double solde;
    private String numeroCarte;
    private int code;
    
    public double getSolde()
    {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public String getNumeroCarte() {
        return numeroCarte;
    }
    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Carte(Client client, double solde, String numeroCarte,int newCode) {
        this.client = client;
        this.solde = solde;
        this.numeroCarte = numeroCarte;
        this.code = newCode;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
