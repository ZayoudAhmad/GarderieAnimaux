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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private Button adm;
    @FXML
    private ImageView logo;
    @FXML
    private ImageView logo1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void loginAdm(ActionEvent event) {
        try {
            Stage logp = new Stage();
            adm.getScene().getWindow().hide();
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
