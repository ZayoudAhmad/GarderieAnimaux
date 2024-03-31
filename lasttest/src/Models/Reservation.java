package Models;

import Models.Client;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation implements Facturable {

    private int idR;
    private Date dateDebut;
    private Date dateFin;
    private float prixParNuite;
    private int idClient;
    private ArrayList<Service> servicesNecessaires;

    public Reservation(int idR, Date dateDebut, Date dateFin, int idClient, float prixParNuite) {
        this.idR = idR;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClient = idClient;
        this.servicesNecessaires = new ArrayList<>();
        this.prixParNuite = prixParNuite;
    }

    // Getters et setters
    public float getPrixParNuite() {
        return prixParNuite;
    }

    public List<Service> getServicesNecessaires() {
        return servicesNecessaires;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public List<Service> getServices() {
        return servicesNecessaires;
    }

    public void choisirService(Service service) {
        servicesNecessaires.add(service);
    }

    public void setPrixParNuite(float prixParNuite) {
        this.prixParNuite = prixParNuite;
    }

    @Override
    public float calculerMontantFacture() {
        float total = 0;

        LocalDate localDateDebut = dateDebut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateFin = dateFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long nbJours = ChronoUnit.DAYS.between(localDateDebut, localDateFin);

        for (Service service : servicesNecessaires) {
            total += service.getTarif();
        }
        total += prixParNuite * nbJours;

        return total;
    }
}
