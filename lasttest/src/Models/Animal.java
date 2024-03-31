package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Animal {

    private String nom;
    private Date dateNaissance;
    private String Type;
    private int proprietaireId;
    private List<VisiteVeterinaire> visitesVeterinaires;

    public Animal(int proprietaireId, String nom, Date dateNaissance, String Type) {
        this.proprietaireId = proprietaireId;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.Type = Type;
        this.visitesVeterinaires = new ArrayList<>();
    }

    public void ajouterVisiteVeterinaire(VisiteVeterinaire visiteVeterinaire) {
        this.visitesVeterinaires.add(visiteVeterinaire);
    }

    public List<VisiteVeterinaire> getVisitesVeterinaires() {
        return visitesVeterinaires;
    }

    public int getProprietaireId() {
        return proprietaireId;
    }

    public void setPrioritaireId(int proprietaireId) {
        this.proprietaireId = proprietaireId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    @Override
    public String toString() {
        return "nom=" + nom;
    }
}
