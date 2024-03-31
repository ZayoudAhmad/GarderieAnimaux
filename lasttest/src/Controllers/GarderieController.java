package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

public class GarderieController implements Initializable {

    @FXML
    private Button dash;
    @FXML
    private Button btnpers;
    @FXML
    private Button logout;
    @FXML
    private Spinner<Integer> n1;
    @FXML
    private Spinner<Integer> n2;
    @FXML
    private Spinner<Integer> n3;
    @FXML
    private Spinner<Integer> n4;
    @FXML
    private Spinner<Integer> n5;
    @FXML
    private Spinner<Integer> n6;
    @FXML
    private Spinner<Integer> n7;
    @FXML
    private Hyperlink catdet;
    @FXML
    private Hyperlink hamdet;
    @FXML
    private Hyperlink dogdet;
    @FXML
    private Hyperlink rabitdet;
    @FXML
    private Hyperlink birddet;
    @FXML
    private Hyperlink duckdet;
    @FXML
    private Hyperlink tortdet;
    @FXML
    private Button btnclt;
    @FXML
    private Button btnrsv;
    @FXML
    private Button btnSrvc;

    public void initializeSpinner() {
        n1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(20, Integer.MAX_VALUE, 50, 1));
        n2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(27, Integer.MAX_VALUE, 47, 1));
        n3.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(50, Integer.MAX_VALUE, 60, 1));
        n4.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(30, Integer.MAX_VALUE, 80, 1));
        n5.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(42, Integer.MAX_VALUE, 60, 1));
        n6.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(50, Integer.MAX_VALUE, 70, 1));
        n7.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(40, Integer.MAX_VALUE, 60, 1));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeSpinner();
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
        logout.getScene().getWindow().hide();
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

    private void fleshTop(ActionEvent event) {
        // Increment the value of the Spinner
        Spinner<Integer> spinner = (Spinner<Integer>) event.getSource();
        spinner.getValueFactory().increment(1);
    }

    private void fleshDesc(ActionEvent event) {
        // Decrement the value of the Spinner
        Spinner<Integer> spinner = (Spinner<Integer>) event.getSource();
        spinner.getValueFactory().decrement(1);
    }

    @FXML
    private void catDetails(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        catdet.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/views/catDetail.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void HamsterDetails(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        hamdet.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/views/hamsterDetails.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void DogDetails(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        dogdet.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/views/dogDetail.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void RabbitDetails(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        rabitdet.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/views/RabbitDetails.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void BirdsDetails(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        birddet.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/views/birdsDetails.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void DuckDetails(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        duckdet.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/views/Duck.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

    @FXML
    private void TortuleDetails(ActionEvent event) throws IOException {
        Stage logp = new Stage();
        tortdet.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/views/tortleDetail.fxml"));
        Scene scene = new Scene(root);
        logp.setScene(scene);
        logp.show();
        logp.setResizable(false);
    }

}
