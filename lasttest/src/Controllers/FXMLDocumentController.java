package Controllers;

import Models.mysqlconnect;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    private LineChart<?, ?> lineChart;
    @FXML
    private PieChart pieChart;
    private Button logout;
    @FXML
    private Button btnclt;
    @FXML
    private Button btnpers;
    @FXML
    private Button btnSrvc;
    @FXML
    private Button btnanm;
    @FXML
    private Button btnrsv;
    @FXML
    private Label nbrServices;
    @FXML
    private Label nbrAnimals;
    @FXML
    private Label nbrClients;
    @FXML
    private Button btnGrd;
    @FXML
    private Button Logout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iniLineChart();
        iniPieChar();
        updateCounts();
    }

    private void updateCounts() {
        int serviceCount = mysqlconnect.getCountServices();
        int animalCount = mysqlconnect.getCountAnimals();
        int clientCount = mysqlconnect.getCountClients();

        nbrServices.setText(String.valueOf(serviceCount));
        nbrAnimals.setText(String.valueOf(animalCount));
        nbrClients.setText(String.valueOf(clientCount));
    }

    public void iniLineChart() {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("January", 8));
        series.getData().add(new XYChart.Data("February", 12));
        series.getData().add(new XYChart.Data("March", 10));
        series.getData().add(new XYChart.Data("April", 15));
        series.getData().add(new XYChart.Data("Mai", 8));
        series.getData().add(new XYChart.Data("June", 5));
        lineChart.getData().addAll(series);
        lineChart.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
    }

    public void iniPieChar() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Personnel", 150),
                new PieChart.Data("Maintenance", 300),
                new PieChart.Data("Produit", 100),
                new PieChart.Data("Personnel", 30)
        );
        pieChart.setData(pieChartData);
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
}
