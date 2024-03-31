package Models;

import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mysqlconnect {

    Connection conn = null;

    public static Connection ConnectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/garderie");
            //JOptionPane.showMessageDialog(null, "ConnectionEstablished");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static int getCountServices() {
        int count = 0;
        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) AS count FROM Service")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int getCountAnimals() {
        int count = 0;
        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) AS count FROM Animal")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int getCountClients() {
        int count = 0;
        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) AS count FROM Client")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static ObservableList<Personnel> getDataPersonnel() {
        Connection conn = ConnectDb();
        ObservableList<Personnel> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from personnel");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Personnel(Integer.parseInt(rs.getString("Cin")), rs.getString("Nom"), rs.getString("Adresse"), rs.getString("Tel"), rs.getString("Poste"), Float.parseFloat(rs.getString("Salaire"))));
            }
        } catch (java.lang.Exception e) {
        }
        return list;
    }

    public static void insertPersonnel(Personnel personnel) {
        try {
            Connection conn = ConnectDb();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO personnel (Cin, Nom, Adresse, Tel, Poste, Salaire) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, personnel.getCin());
            ps.setString(2, personnel.getNom());
            ps.setString(3, personnel.getAdresse());
            ps.setString(4, personnel.getTelephone());
            ps.setString(5, personnel.getPoste());
            ps.setFloat(6, personnel.getSalaire());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletePersonnel(Personnel personnel) {
        try {
            Connection conn = ConnectDb();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM personnel WHERE Cin = ?");
            ps.setInt(1, personnel.getCin());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updatePersonnel(Personnel personnel) {
        try {
            Connection conn = ConnectDb();
            PreparedStatement ps = conn.prepareStatement("UPDATE personnel SET Nom = ?, Adresse = ?, Tel = ?, Poste = ?, Salaire = ? WHERE Cin = ?");
            ps.setString(1, personnel.getNom());
            ps.setString(2, personnel.getAdresse());
            ps.setString(3, personnel.getTelephone());
            ps.setString(4, personnel.getPoste());
            ps.setFloat(5, personnel.getSalaire());
            ps.setInt(6, personnel.getCin());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Client> getDataClients() {
        Connection conn = ConnectDb();
        ObservableList<Client> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Client");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Client client = new Client(
                        rs.getInt("CIN"),
                        rs.getString("nom"),
                        rs.getString("adresse"),
                        rs.getString("telephone"),
                        rs.getString("email"));

                List<Animal> animals = getAnimalsForClient(client.getCin());
                client.getAnimaux().addAll(animals);

                list.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insertClient(Client client) {
        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement("INSERT INTO Client (CIN, nom, adresse, telephone, email) VALUES (?, ?, ?, ?, ?)")) {

            ps.setInt(1, client.getCin());
            ps.setString(2, client.getNom());
            ps.setString(3, client.getAdresse());
            ps.setString(4, client.getTelephone());
            ps.setString(5, client.getEmail());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteClient(Client client) {
        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement("DELETE FROM Client WHERE CIN = ?")) {

            ps.setInt(1, client.getCin());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateClient(Client client) {
        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement("UPDATE Client SET nom = ?, adresse = ?, telephone = ?, email = ? WHERE CIN = ?")) {

            ps.setString(1, client.getNom());
            ps.setString(2, client.getAdresse());
            ps.setString(3, client.getTelephone());
            ps.setString(4, client.getEmail());
            ps.setInt(5, client.getCin());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Animal> getAnimalsForClient(int cin) {
        List<Animal> animals = new ArrayList<>();

        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM Animal WHERE proprietaire_id = ?")) {

            ps.setInt(1, cin);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Animal animal = new Animal(
                        rs.getInt("proprietaire_id"),
                        rs.getString("nom"),
                        rs.getDate("dateNaissance"),
                        rs.getString("Type"));

                List<VisiteVeterinaire> visits = getVisitsForAnimal(rs.getInt("animal_id"));
                animal.getVisitesVeterinaires().addAll(visits);

                animals.add(animal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animals;
    }

    public static List<VisiteVeterinaire> getVisitsForAnimal(int animalId) {
        List<VisiteVeterinaire> visits = new ArrayList<>();

        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM VisiteVeterinaire WHERE animal_id = ?")) {

            ps.setInt(1, animalId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                VisiteVeterinaire visite = new VisiteVeterinaire(
                        rs.getDate("dateVisite"),
                        rs.getString("notes"));

                visits.add(visite);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return visits;
    }

    public static ObservableList<Animal> getDataAnimals() {
        Connection conn = ConnectDb();
        ObservableList<Animal> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Animal");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Animal animal = new Animal(
                        rs.getInt("proprietaire_id"),
                        rs.getString("nom"),
                        rs.getDate("dateNaissance"),
                        rs.getString("Type"));

                List<VisiteVeterinaire> visits = getVisitsForAnimal(rs.getInt("animal_id"));
                animal.getVisitesVeterinaires().addAll(visits);

                list.add(animal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insertAnimal(Animal animal) {
        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement("INSERT INTO Animal (proprietaire_id, nom, dateNaissance, Type) VALUES (?, ?, ?, ?)")) {

            ps.setInt(1, animal.getProprietaireId());
            ps.setString(2, animal.getNom());
            ps.setDate(3, new java.sql.Date(animal.getDateNaissance().getTime()));
            ps.setString(4, animal.getType());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteAnimal(Animal animal) {
        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement("DELETE FROM Animal WHERE proprietaire_id = ? AND nom = ?")) {

            ps.setInt(1, animal.getProprietaireId());
            ps.setString(2, animal.getNom());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateAnimal(Animal originalAnimal, int updatedProprietaireId, String updatedNom, Date updatedDateNaissance, String updatedType) {
        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement("UPDATE Animal SET proprietaire_id = ?, nom = ?, dateNaissance = ?, Type = ? WHERE animal_id = ?")) {
            ps.setInt(1, updatedProprietaireId);
            ps.setString(2, updatedNom);
            ps.setObject(3, new java.sql.Date(updatedDateNaissance.getTime()));
            ps.setString(4, updatedType);
            ps.setInt(5, originalAnimal.getProprietaireId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Service> getDataService() {
        Connection conn = ConnectDb();
        ObservableList<Service> serviceList = FXCollections.observableArrayList();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM Service");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Service service = new Service(
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getFloat("tarif"),
                        rs.getInt("idReservation")
                ) {
                    @Override
                    public float calculerMontantFacture() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                };
                serviceList.add(service);
            }

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return serviceList;
    }

    public static void insertService(Service service) {
        Connection conn = ConnectDb();

        try {
            String query = "INSERT INTO Service (nom, description, tarif, idReservation) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, service.getNom());
            pst.setString(2, service.getDescription());
            pst.setFloat(3, service.getTarif());
            pst.setInt(4, service.getIdReservation());

            pst.executeUpdate();

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteService(Service service) {
        Connection conn = ConnectDb();

        try {
            String query = "DELETE FROM Service WHERE nom=?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, service.getNom());

            pst.executeUpdate();

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void updateService(Service selectedService, String newNom, String newDescription, float newTarif, int newIdReservation) {
        Connection conn = ConnectDb();
        try {
            String query = "UPDATE Service SET nom=?, description=?, tarif=?, idReservation=? WHERE nom=?";
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, newNom);
            pst.setString(2, newDescription);
            pst.setFloat(3, newTarif);
            pst.setInt(4, newIdReservation);
            pst.setString(5, selectedService.getNom());

            pst.executeUpdate();

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ObservableList<Reservation> getDataReservations() {
        Connection conn = ConnectDb();
        ObservableList<Reservation> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reservation");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reservation reservation = new Reservation(
                        rs.getInt("idR"),
                        rs.getDate("dateDebut"),
                        rs.getDate("dateFin"),
                        rs.getInt("idClient"),
                        rs.getFloat("prixParNuite"));

                List<Service> services = getServicesForReservation(reservation.getIdR());
                reservation.getServices().addAll(services);

                list.add(reservation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void insertReservation(Reservation reservation) {
        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO Reservation (idR, dateDebut, dateFin, idClient, prixParNuite) VALUES (?, ?, ?, ?, ?, ?)")) {

            ps.setInt(1, reservation.getIdR());
            ps.setDate(2, new java.sql.Date(reservation.getDateDebut().getTime()));
            ps.setDate(3, new java.sql.Date(reservation.getDateFin().getTime()));
            ps.setInt(4, reservation.getIdClient());
            ps.setFloat(5, reservation.getPrixParNuite());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteReservation(Reservation reservation) {
        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM Reservation WHERE idR = ?")) {

            ps.setInt(1, reservation.getIdR());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateReservation(Reservation reservation) {
        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement(
                "UPDATE Reservation SET dateDebut = ?, dateFin = ?, idClient = ?, prixParNuite = ? WHERE idR = ?")) {

            ps.setDate(1, new java.sql.Date(reservation.getDateDebut().getTime()));
            ps.setDate(2, new java.sql.Date(reservation.getDateFin().getTime()));
            ps.setInt(3, reservation.getIdClient());
            ps.setFloat(4, reservation.getPrixParNuite());
            ps.setInt(6, reservation.getIdR());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Service> getServicesForReservation(int idR) {
        List<Service> services = new ArrayList<>();

        try (Connection conn = ConnectDb(); PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM Service WHERE idReservation = ?")) {

            ps.setInt(1, idR);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Service service = new Service(
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getFloat("tarif"),
                        rs.getInt("idReservation")) {
                    @Override
                    public float calculerMontantFacture() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }
                };
                services.add(service);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return services;
    }

}
