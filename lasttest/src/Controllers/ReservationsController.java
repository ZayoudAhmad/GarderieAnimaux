package Controllers;

import Models.Animal;
import Models.Client;
import Models.Reservation;
import Models.Service;
import Models.mysqlconnect;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Modality;
import java.util.Date;
import javafx.beans.binding.Bindings;

public class ReservationsController implements Initializable {

    @FXML
    private Button dash;
    @FXML
    private Button btnpers;
    @FXML
    private TableView<Reservation> table;
    @FXML
    private TableColumn<Reservation, Integer> IdReservation;
    @FXML
    private TableColumn<Reservation, Date> DateDebut;
    @FXML
    private TableColumn<Reservation, Date> DateFin;
    @FXML
    private TableColumn<Reservation, Float> PrixNuite;
    @FXML
    private TableColumn<Reservation, Integer> idClient;
    @FXML
    private TableColumn<Reservation, ArrayList> listService;

    private ObservableList<Reservation> listR;
    @FXML
    private Button btnclt;
    @FXML
    private Button btnanmx;
    @FXML
    private Button btnSrvc;
    @FXML
    private Button btnGrd;
    @FXML
    private Button Logout;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IdReservation.setCellValueFactory(new PropertyValueFactory<>("idR"));
        DateDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        DateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        PrixNuite.setCellValueFactory(new PropertyValueFactory<>("prixParNuite"));
        idClient.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        listService.setCellValueFactory(new PropertyValueFactory<>("servicesNecessaires"));

        listR = mysqlconnect.getDataReservations();
        table.setItems(listR);
    }

    @FXML
    private void ClickDash(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        dash.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/views/FXMLDocument_1.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void Clickclt(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        btnclt.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/views/Clients.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void Clickpers(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        btnpers.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/views/Personnel_1.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void ClickAnmx(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        btnanmx.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/views/Animaux.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void Clicklogout(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        Logout.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void ClickService(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        btnSrvc.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/views/Services.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void ClickGarderie(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        btnGrd.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/views/Garderie.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void ajouterReservation(ActionEvent event) {

        TextField idRField = new TextField();
        idRField.setPromptText("ID de la réservation");

        DatePicker dateDebutPicker = new DatePicker();
        dateDebutPicker.setPromptText("Date de début");

        DatePicker dateFinPicker = new DatePicker();
        dateFinPicker.setPromptText("Date de fin");

        TextField prixParNuiteField = new TextField();
        prixParNuiteField.setPromptText("Prix par nuitée");

        TextField idClientField = new TextField();
        idClientField.setPromptText("ID du client");

        Dialog<Pair<Boolean, Reservation>> dialog = new Dialog<>();
        dialog.setTitle("Ajouter Réservation");
        dialog.setHeaderText("Ajouter une nouvelle Réservation");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("ID Réservation:"), 0, 0);
        grid.add(idRField, 1, 0);
        grid.add(new Label("Date de début:"), 0, 1);
        grid.add(dateDebutPicker, 1, 1);
        grid.add(new Label("Date de fin:"), 0, 2);
        grid.add(dateFinPicker, 1, 2);
        grid.add(new Label("Prix par nuitée:"), 0, 3);
        grid.add(prixParNuiteField, 1, 3);
        grid.add(new Label("ID du client:"), 0, 4);
        grid.add(idClientField, 1, 4);

        dialog.getDialogPane().setContent(grid);

        ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

        Node okButton = dialog.getDialogPane().lookupButton(okButtonType);
        okButton.setDisable(true);

        BooleanBinding fieldsValid = Bindings.createBooleanBinding(()
                -> idRField.getText().trim().isEmpty()
                || dateDebutPicker.getValue() == null
                || dateFinPicker.getValue() == null
                || prixParNuiteField.getText().trim().isEmpty()
                || idClientField.getText().trim().isEmpty(),
                idRField.textProperty(),
                dateDebutPicker.valueProperty(),
                dateFinPicker.valueProperty(),
                prixParNuiteField.textProperty(),
                idClientField.textProperty()
        );

        okButton.disableProperty().bind(fieldsValid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                return new Pair<>(true, new Reservation(
                        Integer.parseInt(idRField.getText()),
                        java.sql.Date.valueOf(dateDebutPicker.getValue()),
                        java.sql.Date.valueOf(dateFinPicker.getValue()),
                        Integer.parseInt(idClientField.getText()),
                        Float.parseFloat(prixParNuiteField.getText())
                ));
            }
            return new Pair<>(false, null);
        });

        Optional<Pair<Boolean, Reservation>> result = dialog.showAndWait();

        result.ifPresent(pair -> {
            if (pair.getKey()) {
                Reservation newReservation = pair.getValue();

                mysqlconnect.insertReservation(newReservation);

                listR.add(newReservation);
                table.refresh();
            }
        });
    }

    @FXML
    private void supprimerReservation(ActionEvent event) {

        Reservation selectedReservation = table.getSelectionModel().getSelectedItem();

        if (selectedReservation != null) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Voulez-vous vraiment supprimer cette réservation ?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {

                mysqlconnect.deleteReservation(selectedReservation);

                listR.remove(selectedReservation);

                table.refresh();
            }
        } else {
            showAlert("Aucune Réservation sélectionnée", "Veuillez sélectionner une Réservation à supprimer.");
        }
    }

    @FXML
    private void updateReservation(ActionEvent event) {

        Reservation selectedReservation = table.getSelectionModel().getSelectedItem();

        if (selectedReservation != null) {

            LocalDate localDateDebut = new java.util.Date(selectedReservation.getDateDebut().getTime()).toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate localDateFin = new java.util.Date(selectedReservation.getDateFin().getTime()).toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            DatePicker dateDebutPicker = new DatePicker(localDateDebut);
            DatePicker dateFinPicker = new DatePicker(localDateFin);
            TextField prixNuiteField = new TextField(String.valueOf(selectedReservation.getPrixParNuite()));
            TextField idClientField = new TextField(String.valueOf(selectedReservation.getIdClient()));

            Dialog<Pair<Boolean, Reservation>> dialog = new Dialog<>();
            dialog.setTitle("Modifier Réservation");
            dialog.setHeaderText("Modifier les détails de la Réservation");

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            grid.add(new Label("Date Début:"), 0, 0);
            grid.add(dateDebutPicker, 1, 0);
            grid.add(new Label("Date Fin:"), 0, 1);
            grid.add(dateFinPicker, 1, 1);
            grid.add(new Label("Prix par Nuité:"), 0, 2);
            grid.add(prixNuiteField, 1, 2);
            grid.add(new Label("ID Client:"), 0, 3);
            grid.add(idClientField, 1, 3);

            dialog.getDialogPane().setContent(grid);

            ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

            Node okButton = dialog.getDialogPane().lookupButton(okButtonType);
            okButton.setDisable(true);

            BooleanBinding fieldsValid = Bindings.createBooleanBinding(()
                    -> dateDebutPicker.getValue() == null
                    || dateFinPicker.getValue() == null
                    || prixNuiteField.getText().trim().isEmpty()
                    || idClientField.getText().trim().isEmpty(),
                    dateDebutPicker.valueProperty(),
                    dateFinPicker.valueProperty(),
                    prixNuiteField.textProperty(),
                    idClientField.textProperty()
            );

            okButton.disableProperty().bind(fieldsValid);

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == okButtonType) {
                    return new Pair<>(true, new Reservation(
                            selectedReservation.getIdR(),
                            java.sql.Date.valueOf(dateDebutPicker.getValue()),
                            java.sql.Date.valueOf(dateFinPicker.getValue()),
                            Integer.parseInt(idClientField.getText()),
                            Float.parseFloat(prixNuiteField.getText())
                    ));
                }
                return new Pair<>(false, null);
            });

            Optional<Pair<Boolean, Reservation>> result = dialog.showAndWait();

            result.ifPresent(pair -> {
                if (pair.getKey()) {
                    Reservation updatedReservation = pair.getValue();

                    selectedReservation.setDateDebut(updatedReservation.getDateDebut());
                    selectedReservation.setDateFin(updatedReservation.getDateFin());
                    selectedReservation.setPrixParNuite(updatedReservation.getPrixParNuite());
                    selectedReservation.setIdClient(updatedReservation.getIdClient());

                    mysqlconnect.updateReservation(selectedReservation);

                    table.refresh();
                }
            });
        } else {
            showAlert("Aucune Réservation sélectionnée", "Veuillez sélectionner une Réservation à mettre à jour.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
