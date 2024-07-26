package application;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class LoginController {

    @FXML
    private PasswordField masterPasswordField;

    @FXML
    private void handleLogin() {
        String masterPassword = masterPasswordField.getText();
        if (masterPassword.equals("masterpassword")) { // Replace with your actual master password logic
            try {
                Stage stage = (Stage) masterPasswordField.getScene().getWindow();
                AnchorPane root = FXMLLoader.load(getClass().getResource("PassLock.fxml"));
                Scene scene = new Scene(root, 451, 422);
                stage.setScene(scene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Show error message
            System.out.println("Invalid master password");
        }
    }
}