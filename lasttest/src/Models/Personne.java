package Models;

public sealed abstract class Personne permits Client, Personnel, Admin {

    private int CIN;
    private String nom;
    private String adresse;
    private String telephone;

    public Personne(int CIN, String nom, String adresse, String telephone) {

        this.CIN = CIN;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public int getCin() {
        return CIN;
    }

    public void setCIN(int CIN) {
        this.CIN = CIN;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
}
