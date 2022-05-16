package com.example.carbonbattles;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthenticateController {


    @FXML
    private Label loginMessageLabel;
    @FXML
    private Button signInButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Hyperlink forgotPasswordLink;
    @FXML
    private Hyperlink notMemberLink;
    @FXML
    private Button signOutButton;
    private Scene scene;
    private Parent root;
    private Stage stage;


    public void signInButtonOnAction(ActionEvent event) throws IOException {
        if(usernameTextField.getText().toString().equals("Adam123") && passwordField.getText().toString().equals("696969")) {
            loginMessageLabel.setText("Succes!");
            Parent root = FXMLLoader.load(getClass().getResource("MedewerkerMenu.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("CarbonBattles");
            stage.setResizable(false);
            stage.show();
        }
        else if (usernameTextField.getText().isBlank() == true && passwordField.getText().isBlank() == true){
            loginMessageLabel.setText("Please enter your Username and Password.");
        }
        else{
            loginMessageLabel.setText("Incorrect credentials!");
        }
    }

}
