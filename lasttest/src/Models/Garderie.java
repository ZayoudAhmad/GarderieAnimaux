package Models;

import java.util.ArrayList;
import java.util.List;

public class Garderie {

    private String nom;
    private String adresse;
    private String telephone;
    private int capaciteMaximale;
    private int capaciteCourant;
    private List<Animal> animaux;
    private List<Zone> zones;
    private List<Personnel> personnels;

    public Garderie(String nom, String adresse, String telephone, int capaciteMaximale, int capaciteCourant) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.capaciteMaximale = capaciteMaximale;
        this.capaciteCourant = capaciteCourant;
        this.animaux = new ArrayList<>();
        this.zones = new ArrayList<>();
        this.personnels = new ArrayList<>();
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

    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }

    public int getcapaciteCourant() {
        return capaciteCourant;
    }

    public void setcapaciteCourant(int capaciteCourant) {
        this.capaciteCourant = capaciteCourant;
    }

    public void setCapaciteMaximale(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
    }

    public void ajouterAnimal(Animal animal) throws CapaciteMaximaleAtteinteException {
        if (capaciteMaximale == capaciteCourant) {
            throw new CapaciteMaximaleAtteinteException("La capacité maximale de la garderie est atteinte.");
        } else {
            animaux.add(animal);
            capaciteCourant++;
        }
    }

    public void retirerAnimal(Animal animal) throws CapaciteMaximaleDepasseException {
        if (capaciteCourant == 0) {
            throw new CapaciteMaximaleDepasseException("La capacité maximale ne peut pas dépasser la valeur initiale.");
        } else {
            animaux.remove(animal);
            capaciteCourant--;
        }
    }

    public List<Animal> getAllAnimals() {
        return this.animaux;
    }

    public boolean isAnimalInDaycare(Animal animal) {
        return this.animaux.contains(animal);
    }

    public void ajouterZone(Zone zone) {
        zones.add(zone);
    }

    public void afficherAnimaux() {
        System.out.println("Animaux présents dans la garderie :");
        for (Animal animal : animaux) {
            System.out.println("Nom : " + animal.getNom() + ", Date de Naissance : " + animal.getDateNaissance());
        }
    }

    public void ajouterPersonnel(Personnel personnel) {
        this.personnels.add(personnel);
    }

    public void retirerPersonnel(Personnel personnel) {
        this.personnels.remove(personnel);
    }

    public void afficherPersonnel() {
        System.out.println("Animaux présents dans la personnel :");
        for (Personnel personnel : personnels) {
            System.out.println("Nom : " + personnel.getPoste());
        }
    }
}
