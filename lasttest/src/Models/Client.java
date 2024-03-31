package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public final class Client extends Personne {

    private String email;
    private List<Animal> animaux;

    public Client(int CIN, String nom, String adresse, String telephone, String email) {
        super(CIN, nom, adresse, telephone);
        this.email = email;
        this.animaux = new ArrayList<>();

    }

    public void ajouterAnimal(Animal animal) {
        this.animaux.add(animal);
    }

    public ObservableList<Animal> getAnimaux() {
        return FXCollections.observableList(animaux);
    }

    // Getters et setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
