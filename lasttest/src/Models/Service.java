package Models;

public abstract class Service implements Facturable {

    private String nom;
    private String description;
    private float tarif;
    private int idReservation;

    public Service(String nom, String description, float tarif, int idReservation) {
        this.nom = nom;
        this.description = description;
        this.tarif = tarif;
        this.idReservation = idReservation;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public float getTarif() {
        return tarif;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    @Override
    public String toString() {
        return "nom=" + nom;
    }

}
