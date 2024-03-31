package Controllers;

import Models.Animal;
import Models.Client;
import Models.mysqlconnect;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
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

public class ClientsController implements Initializable {

    @FXML
    private Button dash;
    @FXML
    private Button btnpers;
    @FXML
    private Button logout;
    @FXML
    private Button ajouterclient;
    @FXML
    private TableView<Client> tab;
    private ObservableList<Client> list;
    @FXML
    private TableColumn<Client, String> Nom;
    @FXML
    private TableColumn<Client, Integer> CIN;
    @FXML
    private TableColumn<Client, String> Adresse;
    @FXML
    private TableColumn<Client, String> Telephone;
    @FXML
    private TableColumn<Client, String> Email;
    @FXML
    private TableColumn<Client, ArrayList> animals;
    @FXML
    private Button updateClient;
    @FXML
    private Button btnrsv;
    @FXML
    private Button btnSrvc;
    @FXML
    private Button btnGrd;
    @FXML
    private TextField cinSearchField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the TableView columns
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        CIN.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Telephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        animals.setCellValueFactory(new PropertyValueFactory<>("animaux"));

        list = mysqlconnect.getDataClients();
        tab.setItems(list);

        cinSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            search(null);
        });
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
    private void Clicklogout(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        logout.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
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
    private void handleAjouterButton() {

        TextInputDialog nomDialog = new TextInputDialog();
        nomDialog.setTitle("Ajouter Client");
        nomDialog.setHeaderText("Ajouter un nouveau Client");
        nomDialog.setContentText("Nom:");

        Optional<String> nomResult = nomDialog.showAndWait();
        if (!nomResult.isPresent()) {
            return;
        }
        String newNom = nomResult.get();

        TextInputDialog cinDialog = new TextInputDialog();
        cinDialog.setTitle("Ajouter Client");
        cinDialog.setHeaderText("Ajouter un nouveau Client");
        cinDialog.setContentText("CIN:");

        Optional<String> cinResult = cinDialog.showAndWait();
        if (!cinResult.isPresent()) {
            return;
        }
        int nCIN = Integer.parseInt(cinResult.get());

        TextInputDialog adresseDialog = new TextInputDialog();
        adresseDialog.setTitle("Ajouter Client");
        adresseDialog.setHeaderText("Ajouter un nouveau Client");
        adresseDialog.setContentText("Adresse:");

        Optional<String> AdresseResult = adresseDialog.showAndWait();
        if (!AdresseResult.isPresent()) {
            return;
        }
        String newAdresse = AdresseResult.get();

        TextInputDialog telDialog = new TextInputDialog();
        telDialog.setTitle("Ajouter Client");
        telDialog.setHeaderText("Ajouter un nouveau Client");
        telDialog.setContentText("Telephone:");

        Optional<String> telResult = telDialog.showAndWait();
        if (!telResult.isPresent()) {
            return;
        }
        String newTel = telResult.get();

        TextInputDialog emailDialog = new TextInputDialog();
        emailDialog.setTitle("Ajouter Client");
        emailDialog.setHeaderText("Ajouter un nouveau Client");
        emailDialog.setContentText("Email:");

        Optional<String> emailResult = emailDialog.showAndWait();
        if (!emailResult.isPresent()) {
            return;
        }
        String nemail = emailResult.get();

        Client newClient = new Client(nCIN, newNom, newAdresse, newTel, nemail);

        mysqlconnect.insertClient(newClient);

        list.add(newClient);

        tab.refresh();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void handleSupprimerButton(ActionEvent event) {
        Client selectedClient = tab.getSelectionModel().getSelectedItem();

        if (selectedClient != null) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Voulez-vous vraiment supprimer ce client ?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {

                mysqlconnect.deleteClient(selectedClient);

                list.remove(selectedClient);

                tab.refresh();
            }
        } else {
            showAlert("Aucun Profil sélectionné", "Veuillez sélectionner un Profil à supprimer.");
        }
    }

    @FXML
    private void handleUpdateButton(ActionEvent event) {

        Client selectedClient = tab.getSelectionModel().getSelectedItem();

        if (selectedClient != null) {

            Dialog<Pair<Boolean, Client>> dialog = new Dialog<>();
            dialog.setTitle("Modifier Profil");
            dialog.setHeaderText("Modifier les détails de Profil");

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(10);

            TextField nomField = new TextField(selectedClient.getNom());
            TextField cinField = new TextField(Integer.toString(selectedClient.getCin()));
            TextField adresseField = new TextField(selectedClient.getAdresse());
            TextField telField = new TextField(selectedClient.getTelephone());
            TextField emailField = new TextField(selectedClient.getEmail());

            ListView<Animal> animalListView = new ListView<>(selectedClient.getAnimaux());

            grid.add(new Label("Nom:"), 0, 0);
            grid.add(nomField, 1, 0);
            grid.add(new Label("CIN:"), 0, 1);
            grid.add(cinField, 1, 1);
            grid.add(new Label("Adresse:"), 0, 2);
            grid.add(adresseField, 1, 2);
            grid.add(new Label("Telephone:"), 0, 3);
            grid.add(telField, 1, 3);
            grid.add(new Label("Email:"), 0, 4);
            grid.add(emailField, 1, 4);
            grid.add(new Label("Animaux:"), 0, 5);
            grid.add(animalListView, 1, 5);

            dialog.getDialogPane().setContent(grid);

            ButtonType okButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);

            Node okButton = dialog.getDialogPane().lookupButton(okButtonType);
            okButton.setDisable(true);

            BooleanBinding fieldsValid = nomField.textProperty().isEmpty()
                    .or(cinField.textProperty().isEmpty())
                    .or(adresseField.textProperty().isEmpty())
                    .or(telField.textProperty().isEmpty())
                    .or(emailField.textProperty().isEmpty());

            okButton.disableProperty().bind(fieldsValid);

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == okButtonType) {
                    return new Pair<>(true, new Client(
                            Integer.parseInt(cinField.getText()),
                            nomField.getText(),
                            adresseField.getText(),
                            telField.getText(),
                            emailField.getText()));
                }
                return new Pair<>(false, null);
            });

            Optional<Pair<Boolean, Client>> result = dialog.showAndWait();

            result.ifPresent(pair -> {
                if (pair.getKey()) {
                    Client updatedClient = pair.getValue();

                    selectedClient.setCIN(updatedClient.getCin());
                    selectedClient.setNom(updatedClient.getNom());
                    selectedClient.setAdresse(updatedClient.getAdresse());
                    selectedClient.setTelephone(updatedClient.getTelephone());
                    selectedClient.setEmail(updatedClient.getEmail());
                    selectedClient.getAnimaux().setAll(updatedClient.getAnimaux());

                    mysqlconnect.updateClient(selectedClient);

                    tab.refresh();
                }
            });
        } else {
            showAlert("Aucun Profil sélectionné", "Veuillez sélectionner un Profil à mettre à jour.");
        }
    }

    //Stream and collection and lambda
    @FXML
    private void search(MouseEvent event) {
        String searchText = cinSearchField.getText();

        if (searchText.isEmpty()) {

            tab.setItems(list);
        } else {

            ObservableList<Client> filteredList = list.stream()
                    .filter(client -> Integer.toString(client.getCin()).contains(searchText))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));

            tab.setItems(filteredList);
        }
    }

}
