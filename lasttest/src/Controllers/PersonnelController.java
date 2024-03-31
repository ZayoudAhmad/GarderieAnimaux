package Controllers;

import Models.Personnel;
import Models.mysqlconnect;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.stream.Collectors;

public class PersonnelController implements Initializable {

    @FXML
    private Button dash;
    @FXML
    private Button clt;
    @FXML
    private Button pers;
    @FXML
    private Button LogOut;
    private ObservableList<Personnel> list = FXCollections.observableArrayList(
            new Personnel(123456, "Ahmad", "Djerba", "29575456", "Manager", 10000),
            new Personnel(789012, "Louay", "Ariana", "56948166", "Veterinaire", 2500)
    );
    @FXML
    private TableColumn<Personnel, String> nom;
    @FXML
    private TableColumn<Personnel, Integer> cin;
    @FXML
    private TableColumn<Personnel, String> adresse;
    @FXML
    private TableColumn<Personnel, String> tel;
    @FXML
    private TableColumn<Personnel, String> poste;
    @FXML
    private TableColumn<Personnel, Float> salaire;
    @FXML
    private TableView<Personnel> tab;

    ObservableList<Personnel> listM;

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private Button btnanmx;
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
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        tel.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        poste.setCellValueFactory(new PropertyValueFactory<>("poste"));
        salaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));

        listM = mysqlconnect.getDataPersonnel();
        tab.setItems(listM);
    }

    @FXML
    private void Clickdash(ActionEvent event) throws IOException {
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
        clt.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/views/Clients.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void Clickpers(ActionEvent event) {

    }

    @FXML
    private void ClickedLogout(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        LogOut.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
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
    private void ajouterPersonnel(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ajouter Personnel");
        dialog.setHeaderText("Ajouter un nouveau Personnel");
        dialog.setContentText("Nom:");

        Optional<String> nomResult = dialog.showAndWait();
        if (!nomResult.isPresent()) {
            return;
        }
        String newNom = nomResult.get();

        TextInputDialog cinDialog = new TextInputDialog();
        cinDialog.setTitle("Ajouter Personnel");
        cinDialog.setHeaderText("Ajouter un nouveau Personnel");
        cinDialog.setContentText("CIN:");

        Optional<String> cinResult = cinDialog.showAndWait();
        if (!cinResult.isPresent()) {
            return;
        }
        int newCIN = Integer.parseInt(cinResult.get());

        TextInputDialog adresseDialog = new TextInputDialog();
        adresseDialog.setTitle("Ajouter Personnel");
        adresseDialog.setHeaderText("Ajouter un nouveau Personnel");
        adresseDialog.setContentText("Adresse:");

        Optional<String> adresseResult = adresseDialog.showAndWait();
        if (!adresseResult.isPresent()) {
            return;
        }
        String newAdresse = adresseResult.get();

        TextInputDialog telDialog = new TextInputDialog();
        telDialog.setTitle("Ajouter Personnel");
        telDialog.setHeaderText("Ajouter un nouveau Personnel");
        telDialog.setContentText("Téléphone:");

        Optional<String> telResult = telDialog.showAndWait();
        if (!telResult.isPresent()) {
            return;
        }
        String newTel = telResult.get();

        TextInputDialog posteDialog = new TextInputDialog();
        posteDialog.setTitle("Ajouter Personnel");
        posteDialog.setHeaderText("Ajouter un nouveau Personnel");
        posteDialog.setContentText("Poste:");

        Optional<String> posteResult = posteDialog.showAndWait();
        if (!posteResult.isPresent()) {
            return;
        }
        String newPoste = posteResult.get();

        TextInputDialog salaireDialog = new TextInputDialog();
        salaireDialog.setTitle("Ajouter Personnel");
        salaireDialog.setHeaderText("Ajouter un nouveau Personnel");
        salaireDialog.setContentText("Salaire:");

        Optional<String> salaireResult = salaireDialog.showAndWait();
        if (!salaireResult.isPresent()) {
            return;
        }
        float newSalaire = Float.parseFloat(salaireResult.get());

        Personnel newPersonnel = new Personnel(newCIN, newNom, newAdresse, newTel, newPoste, newSalaire);

        mysqlconnect.insertPersonnel(newPersonnel);

        listM = mysqlconnect.getDataPersonnel();
        tab.setItems(listM);
        tab.refresh();
    }

    @FXML
    private void supprimerPersonnel(ActionEvent event) {
        Personnel selectedPersonnel = tab.getSelectionModel().getSelectedItem();

        if (selectedPersonnel != null) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Voulez-vous vraiment supprimer ce personnel ?");
            alert.setContentText(selectedPersonnel.getNom());

            ButtonType buttonTypeOui = new ButtonType("Oui", ButtonData.YES);
            ButtonType buttonTypeNon = new ButtonType("Non", ButtonData.NO);

            alert.getButtonTypes().setAll(buttonTypeOui, buttonTypeNon);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == buttonTypeOui) {

                mysqlconnect.deletePersonnel(selectedPersonnel);

                listM = mysqlconnect.getDataPersonnel();
                tab.setItems(listM);
                tab.refresh();
            }
        } else {
            showAlert("Aucun Personnel sélectionné", "Veuillez sélectionner un Personnel à supprimer.");
        }
    }

    @FXML
    private void updatePersonnel(ActionEvent event) {
        Personnel selectedPersonnel = tab.getSelectionModel().getSelectedItem();

        if (selectedPersonnel != null) {
            Dialog<Pair<Boolean, Personnel>> dialog = new Dialog<>();
            dialog.setTitle("Modifier Profil");
            dialog.setHeaderText("Modifier les détails de Profil");

            ButtonType buttonTypeModifier = new ButtonType("Modifier", ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(buttonTypeModifier, ButtonType.CANCEL);

            TextField nomField = new TextField(selectedPersonnel.getNom());
            TextField cinField = new TextField(Integer.toString(selectedPersonnel.getCin()));
            TextField adresseField = new TextField(selectedPersonnel.getAdresse());
            TextField telField = new TextField(selectedPersonnel.getTelephone());
            TextField posteField = new TextField(selectedPersonnel.getPoste());
            TextField salaireField = new TextField(Float.toString(selectedPersonnel.getSalaire()));

            dialog.getDialogPane().setContent(createGridPane(nomField, cinField, adresseField, telField, posteField, salaireField));

            Node modifierButton = dialog.getDialogPane().lookupButton(buttonTypeModifier);
            modifierButton.setDisable(true);

            nomField.textProperty().addListener((observable, oldValue, newValue) -> {
                modifierButton.setDisable(newValue.trim().isEmpty());
            });

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == buttonTypeModifier) {
                    return new Pair<>(true, new Personnel(
                            Integer.parseInt(cinField.getText()),
                            nomField.getText(),
                            adresseField.getText(),
                            telField.getText(),
                            posteField.getText(),
                            Float.parseFloat(salaireField.getText())
                    ));
                }
                return new Pair<>(false, null);
            });

            Optional<Pair<Boolean, Personnel>> result = dialog.showAndWait();

            result.ifPresent(pair -> {
                if (pair.getKey()) {
                    Personnel updatedPersonnel = pair.getValue();

                    mysqlconnect.updatePersonnel(updatedPersonnel);

                    listM = mysqlconnect.getDataPersonnel();
                    tab.setItems(listM);
                    tab.refresh();
                }
            });
        } else {
            showAlert("Aucun Personnel sélectionné", "Veuillez sélectionner un Personnel à mettre à jour.");
        }
    }

    private GridPane createGridPane(TextField nomField, TextField cinField, TextField adresseField,
            TextField telField, TextField posteField, TextField salaireField) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Nom:"), 0, 0);
        grid.add(nomField, 1, 0);
        grid.add(new Label("CIN:"), 0, 1);
        grid.add(cinField, 1, 1);
        grid.add(new Label("Adresse:"), 0, 2);
        grid.add(adresseField, 1, 2);
        grid.add(new Label("Téléphone:"), 0, 3);
        grid.add(telField, 1, 3);
        grid.add(new Label("Poste:"), 0, 4);
        grid.add(posteField, 1, 4);
        grid.add(new Label("Salaire:"), 0, 5);
        grid.add(salaireField, 1, 5);

        return grid;
    }

    private void showAlert(String header, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void search(ActionEvent event) {
        String searchText = cinSearchField.getText();

        if (searchText.isEmpty()) {

            tab.setItems(listM);
        } else {

            ObservableList<Personnel> filteredList = listM.stream()
                    .filter(personnel -> Integer.toString(personnel.getCin()).contains(searchText))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));

            tab.setItems(filteredList);
        }
    }

}
