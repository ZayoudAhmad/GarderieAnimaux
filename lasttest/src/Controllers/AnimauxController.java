package Controllers;

import Models.Animal;
import Models.Client;
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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Modality;

public class AnimauxController implements Initializable {

    @FXML
    private Button dash;
    @FXML
    private Button btnpers;
    @FXML
    private TableView<Animal> table;
    @FXML
    private TableColumn<Animal, String> nom;
    @FXML
    private TableColumn<Animal, Date> dateNaissance;
    @FXML
    private TableColumn<Animal, String> type;
    @FXML
    private TableColumn<Animal, Integer> proprietaireId;
    ObservableList<Animal> animalList;
    @FXML
    private Button btnclt;
    @FXML
    private Button btnrsv;
    @FXML
    private Button btnSrvc;
    @FXML
    private Button btnGrd;
    @FXML
    private Button Logout;
    @FXML
    private TextField ProprietaireIdSearch;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        dateNaissance.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
        type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        proprietaireId.setCellValueFactory(new PropertyValueFactory<>("proprietaireId"));

        animalList = mysqlconnect.getDataAnimals();

        table.setItems(animalList);
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
    private void ajouterAnimal(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ajouter Animal");
        dialog.setHeaderText("Ajouter un nouvel Animal");
        dialog.setContentText("Nom:");

        Optional<String> nomResult = dialog.showAndWait();
        if (!nomResult.isPresent()) {
            return;
        }
        String newNom = nomResult.get();

        TextInputDialog proprietaireIdDialog = new TextInputDialog();
        proprietaireIdDialog.setTitle("Ajouter Animal");
        proprietaireIdDialog.setHeaderText("Ajouter un nouvel Animal");
        proprietaireIdDialog.setContentText("Proprietaire ID:");

        Optional<String> proprietaireIdResult = proprietaireIdDialog.showAndWait();
        if (!proprietaireIdResult.isPresent()) {
            return;
        }
        int newProprietaireId = Integer.parseInt(proprietaireIdResult.get());

        TextInputDialog dateNaissanceDialog = new TextInputDialog();
        dateNaissanceDialog.setTitle("Ajouter Animal");
        dateNaissanceDialog.setHeaderText("Ajouter un nouvel Animal");
        dateNaissanceDialog.setContentText("Date de Naissance (yyyy-MM-dd):");

        Optional<String> dateNaissanceResult = dateNaissanceDialog.showAndWait();
        if (!dateNaissanceResult.isPresent()) {
            return;
        }
        // Assuming you want to parse the date from the input (replace with your logic)
        Date newDateNaissance = parseDate(dateNaissanceResult.get());

        TextInputDialog typeDialog = new TextInputDialog();
        typeDialog.setTitle("Ajouter Animal");
        typeDialog.setHeaderText("Ajouter un nouvel Animal");
        typeDialog.setContentText("Type:");

        Optional<String> typeResult = typeDialog.showAndWait();
        if (!typeResult.isPresent()) {
            return;
        }
        String newType = typeResult.get();

        Animal newAnimal = new Animal(newProprietaireId, newNom, newDateNaissance, newType);

        mysqlconnect.insertAnimal(newAnimal);

        animalList = mysqlconnect.getDataAnimals();
        table.setItems(animalList);
        table.refresh();
    }

    @FXML
    private void supprimerAnimal(ActionEvent event) {
        Animal selectedAnimal = table.getSelectionModel().getSelectedItem();

        if (selectedAnimal == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aucun animal sélectionné");
            alert.setHeaderText("Veuillez sélectionner un animal à supprimer.");
            alert.showAndWait();
            return;
        }

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmer la suppression");
        confirmation.setHeaderText("Voulez-vous vraiment supprimer l'animal sélectionné?");

        Optional<ButtonType> result = confirmation.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

            mysqlconnect.deleteAnimal(selectedAnimal);

            animalList.remove(selectedAnimal);

            table.refresh();
        }
    }

    @FXML
    private void updateAnimal(ActionEvent event) {

        Animal selectedAnimal = table.getSelectionModel().getSelectedItem();

        if (selectedAnimal != null) {
            Dialog<Pair<Boolean, Animal>> dialog = new Dialog<>();
            dialog.setTitle("Modifier Animal");
            dialog.setHeaderText("Modifier les détails de l'animal");

            ButtonType buttonTypeModifier = new ButtonType("Modifier", ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(buttonTypeModifier, ButtonType.CANCEL);

            TextField proprietaireIdField = new TextField(Integer.toString(selectedAnimal.getProprietaireId()));
            TextField nomField = new TextField(selectedAnimal.getNom());
            DatePicker dateNaissancePicker = new DatePicker(selectedAnimal.getDateNaissance().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            TextField typeField = new TextField(selectedAnimal.getType());

            dialog.getDialogPane().setContent(createGridPane(proprietaireIdField, nomField, dateNaissancePicker, typeField));

            Node modifierButton = dialog.getDialogPane().lookupButton(buttonTypeModifier);
            modifierButton.setDisable(true);

            proprietaireIdField.textProperty().addListener((observable, oldValue, newValue) -> {
                modifierButton.setDisable(newValue.trim().isEmpty());
            });

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == buttonTypeModifier) {
                    return new Pair<>(true, new Animal(
                            Integer.parseInt(proprietaireIdField.getText()),
                            nomField.getText(),
                            java.sql.Date.valueOf(dateNaissancePicker.getValue()),
                            typeField.getText()
                    ));
                }
                return new Pair<>(false, null);
            });

            Optional<Pair<Boolean, Animal>> result = dialog.showAndWait();

            result.ifPresent(pair -> {
                if (pair.getKey()) {
                    Animal updatedAnimal = pair.getValue();

                    Date updatedDateNaissance = new java.sql.Date(updatedAnimal.getDateNaissance().getTime());

                    mysqlconnect.updateAnimal(selectedAnimal, updatedAnimal.getProprietaireId(), updatedAnimal.getNom(), (java.sql.Date) updatedDateNaissance, updatedAnimal.getType());

                    selectedAnimal.setPrioritaireId(updatedAnimal.getProprietaireId());
                    selectedAnimal.setNom(updatedAnimal.getNom());
                    selectedAnimal.setDateNaissance(updatedAnimal.getDateNaissance());
                    selectedAnimal.setType(updatedAnimal.getType());

                    table.refresh();
                }
            });
        } else {
            showAlert("Aucun Animal sélectionné", "Veuillez sélectionner un Animal à mettre à jour.");
        }
    }

    private GridPane createGridPane(TextField proprietaireIdField, TextField nomField, DatePicker dateNaissancePicker, TextField typeField) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Proprietaire ID:"), 0, 0);
        grid.add(proprietaireIdField, 1, 0);
        grid.add(new Label("Nom:"), 0, 1);
        grid.add(nomField, 1, 1);
        grid.add(new Label("Date de naissance:"), 0, 2);
        grid.add(dateNaissancePicker, 1, 2);
        grid.add(new Label("Type:"), 0, 3);
        grid.add(typeField, 1, 3);

        return grid;
    }

    private void showAlert(String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    private void search(ActionEvent event) {
        String searchProprietaireIdText = ProprietaireIdSearch.getText();

        if (searchProprietaireIdText.isEmpty()) {
            table.setItems(animalList);
        } else {
            ObservableList<Animal> filteredList = animalList.stream()
                    .filter(animal -> Integer.toString(animal.getProprietaireId()).contains(searchProprietaireIdText))
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));
            table.setItems(filteredList);
        }
    }
}
