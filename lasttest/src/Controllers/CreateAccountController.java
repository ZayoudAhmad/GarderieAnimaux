package Controllers;

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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class CreateAccountController implements Initializable {

    @FXML
    private Button signin;
    @FXML
    private Hyperlink haveaccount;
    @FXML
    private Button home;

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
    private void AlreadyHaveAccount(ActionEvent event) {
        try {
            Stage logp = new Stage();
            haveaccount.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/views/LoginMed.fxml"));
            Scene scene = new Scene(root);
            logp.setScene(scene);
            logp.show();
            logp.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
