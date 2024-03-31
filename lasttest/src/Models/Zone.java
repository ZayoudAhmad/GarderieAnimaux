package Models;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

public record Zone(String nom, String emplacement, ZoneType type, int capacite) {

    public enum ZoneType {
        INDOOR, OUTDOOR
    }
    // Getters
    public String getNom() {
        return nom;
    }
    public String getEmplacement() {
        return emplacement;
    }
    public ZoneType getType() {
        return type;
    }
    public int getCapacite() {
        return capacite;
    }

    public boolean isAvailable(Date startDate, Date endDate) {

        return true; 
    }

    public float calculateCost(int numOccupants, Date startDate, Date endDate) {

        return 0.0f;
    }
    @Override
    public String toString() {
        return "Zone: " + nom + " (" + type + ") - " + emplacement + " (Capacity: " + capacite + ")";
    }
}
