package Controllers;

import Models.Animal;
import Models.Client;
import Models.Service;
import Models.mysqlconnect;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Modality;

public class ServicesController implements Initializable {

    @FXML
    private Button dash;
    @FXML
    private Button btnpers;
    @FXML
    private TableView<Service> table;
    @FXML
    private TableColumn<Service, String> nom;
    @FXML
    private TableColumn<Service, String> description;
    @FXML
    private TableColumn<Service, Float> tarif;

    private ObservableList<Service> serviceList;
    @FXML
    private TableColumn<Service, Integer> idReservation;
    @FXML
    private Button btnclt;
    @FXML
    private Button btnrsv;
    @FXML
    private Button btnGrd;
    @FXML
    private Button Logout;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        tarif.setCellValueFactory(new PropertyValueFactory<>("tarif"));
        idReservation.setCellValueFactory(new PropertyValueFactory<>("idReservation"));

        serviceList = mysqlconnect.getDataService();
        table.setItems(serviceList);
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
        btnpers.getScene().getWindow().hide();
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
    private void ClickReservation(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        btnrsv.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/views/Reservations.fxml"));
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
    private void ajouterService(ActionEvent event) {
        Dialog<Pair<Boolean, Service>> dialog = new Dialog<>();
        dialog.setTitle("Ajouter Service");
        dialog.setHeaderText("Ajouter un nouveau Service");

        ButtonType buttonTypeAjouter = new ButtonType("Ajouter", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeAjouter, ButtonType.CANCEL);

        TextField nomField = new TextField();
        TextField descriptionField = new TextField();
        TextField tarifField = new TextField();
        TextField idReservationField = new TextField();

        dialog.getDialogPane().setContent(createGridPane(nomField, descriptionField, tarifField, idReservationField));

        Node ajouterButton = dialog.getDialogPane().lookupButton(buttonTypeAjouter);
        ajouterButton.setDisable(true);

        nomField.textProperty().addListener((observable, oldValue, newValue) -> {
            ajouterButton.setDisable(newValue.trim().isEmpty() || descriptionField.getText().trim().isEmpty()
                    || tarifField.getText().trim().isEmpty() || idReservationField.getText().trim().isEmpty());
        });

        descriptionField.textProperty().addListener((observable, oldValue, newValue) -> {
            ajouterButton.setDisable(newValue.trim().isEmpty() || nomField.getText().trim().isEmpty()
                    || tarifField.getText().trim().isEmpty() || idReservationField.getText().trim().isEmpty());
        });

        tarifField.textProperty().addListener((observable, oldValue, newValue) -> {
            ajouterButton.setDisable(newValue.trim().isEmpty() || nomField.getText().trim().isEmpty()
                    || descriptionField.getText().trim().isEmpty() || idReservationField.getText().trim().isEmpty());
        });

        idReservationField.textProperty().addListener((observable, oldValue, newValue) -> {
            ajouterButton.setDisable(newValue.trim().isEmpty() || nomField.getText().trim().isEmpty()
                    || descriptionField.getText().trim().isEmpty() || tarifField.getText().trim().isEmpty());
        });

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonTypeAjouter) {
                return new Pair<>(true, new Service(
                        nomField.getText(),
                        descriptionField.getText(),
                        Float.parseFloat(tarifField.getText()),
                        Integer.parseInt(idReservationField.getText())
                ) {
                    @Override
                    public float calculerMontantFacture() {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }
                });
            }
            return new Pair<>(false, null);
        });

        Optional<Pair<Boolean, Service>> result = dialog.showAndWait();

        result.ifPresent(pair -> {
            if (pair.getKey()) {
                Service newService = pair.getValue();

                mysqlconnect.insertService(newService);

                serviceList = mysqlconnect.getDataService();
                table.setItems(serviceList);
                table.refresh();
            }
        });
    }

    @FXML
    private void supprimerService(ActionEvent event) {
        Service selectedService = table.getSelectionModel().getSelectedItem();

        if (selectedService != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Supprimer le service");
            alert.setContentText("Êtes-vous sûr de vouloir supprimer le service sélectionné?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {

                mysqlconnect.deleteService(selectedService);

                serviceList = mysqlconnect.getDataService();
                table.setItems(serviceList);
                table.refresh();
            }
        } else {
            showAlert("Aucun service sélectionné", "Veuillez sélectionner un service à supprimer.");
        }
    }

    @FXML
    private void updateService(ActionEvent event) {
        Service selectedService = table.getSelectionModel().getSelectedItem();

        if (selectedService != null) {
            Dialog<Pair<Boolean, Service>> dialog = new Dialog<>();
            dialog.setTitle("Modifier Service");
            dialog.setHeaderText("Modifier les détails du service");

            ButtonType buttonTypeModifier = new ButtonType("Modifier", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(buttonTypeModifier, ButtonType.CANCEL);

            TextField nomField = new TextField(selectedService.getNom());
            TextField descriptionField = new TextField(selectedService.getDescription());
            TextField tarifField = new TextField(Float.toString(selectedService.getTarif()));
            TextField idReservationField = new TextField(Integer.toString(selectedService.getIdReservation()));

            dialog.getDialogPane().setContent(createGridPane(nomField, descriptionField, tarifField, idReservationField));

            Node modifierButton = dialog.getDialogPane().lookupButton(buttonTypeModifier);
            modifierButton.setDisable(true);

            nomField.textProperty().addListener((observable, oldValue, newValue) -> {
                modifierButton.setDisable(newValue.trim().isEmpty());
            });

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == buttonTypeModifier) {
                    return new Pair<>(true, new Service(
                            nomField.getText(),
                            descriptionField.getText(),
                            Float.parseFloat(tarifField.getText()),
                            Integer.parseInt(idReservationField.getText())
                    ) {
                        @Override
                        public float calculerMontantFacture() {
                            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                        }
                    });
                }
                return new Pair<>(false, null);
            });

            Optional<Pair<Boolean, Service>> result = dialog.showAndWait();

            result.ifPresent(pair -> {
                if (pair.getKey()) {
                    Service updatedService = pair.getValue();

                    mysqlconnect.updateService(selectedService, updatedService.getNom(), updatedService.getDescription(), updatedService.getTarif(), updatedService.getIdReservation());

                    serviceList = mysqlconnect.getDataService();
                    table.setItems(serviceList);
                    table.refresh();
                }
            });
        } else {
            showAlert("Aucun service sélectionné", "Veuillez sélectionner un service à mettre à jour.");
        }
    }

    private GridPane createGridPane(TextField nomField, TextField descriptionField, TextField tarifField, TextField idReservationField) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Nom:"), 0, 0);
        grid.add(nomField, 1, 0);
        grid.add(new Label("Description:"), 0, 1);
        grid.add(descriptionField, 1, 1);
        grid.add(new Label("Tarif:"), 0, 2);
        grid.add(tarifField, 1, 2);
        grid.add(new Label("ID Reservation:"), 0, 3);
        grid.add(idReservationField, 1, 3);

        return grid;
    }

    private void showAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
