package Controllers;

import Models.Admin;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginAdmController implements Initializable {

    @FXML
    private Button admBtn;
    @FXML
    private TextField login;
    @FXML
    private PasswordField pswd;
    @FXML
    private Button home;
    @FXML
    private Hyperlink createaccount;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void HomeActionBtn(ActionEvent event) {
        try {
            Stage logp = new Stage();
            home.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
            Scene scene = new Scene(root);
            logp.setScene(scene);
            logp.show();
            logp.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void CreateActionHyper(ActionEvent event) {
        try {
            Stage logp = new Stage();
            createaccount.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/views/CreateAccount.fxml"));
            Scene scene = new Scene(root);
            logp.setScene(scene);
            logp.show();
            logp.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Connexion(ActionEvent event) throws IOException {
        Admin ad = new Admin("12345", 1320, "Louay", "Ariana", "56948166");
        admBtn.getScene().getWindow().hide();
        if ((login.getText().equals(ad.getNom())) && (pswd.getText().equals(ad.getPassword()))) {
            Parent root = FXMLLoader.load(getClass().getResource("/views/FXMLDocument_1.fxml"));
            Stage logp = new Stage();
            Scene scene = new Scene(root);
            logp.setScene(scene);
            logp.show();
            logp.setResizable(true);
            music.playSound("./mp3.mp3");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Login or PASSWORD ERROR");
            alert.setContentText("Please try again");
            alert.showAndWait();
        }
    }
}
