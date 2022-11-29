package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField dad;
    @FXML
    private TextField email;
    @FXML
    private TextField family;
    @FXML
    private TextField name;
    @FXML
    private PasswordField password;
    @FXML
    private TextField phone;
    @FXML
    private Button regButton;
    @FXML
    private Button signUpButton;
    @FXML
    void initialize() {
        DbHandler dbhandler = new DbHandler();
        regButton.setOnAction(event -> {
                dbhandler.regUser(dad.getText(), email.getText(), family.getText(),
                        name.getText(), password.getText(), phone.getText());
                regButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/sginUp.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
        });
        signUpButton.setOnAction(event -> {
                signUpButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Controller.this.getClass().getResource("/sample/sginUp.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
        });
    }
}