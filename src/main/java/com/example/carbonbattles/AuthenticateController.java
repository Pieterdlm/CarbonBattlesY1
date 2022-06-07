package com.example.carbonbattles;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthenticateController{


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



    public void checkLogin(ActionEvent event) throws IOException{
        if (Authenticate.checkBlank(usernameTextField.getText(), passwordField.getText())){
            loginMessageLabel.setText("Please enter your Username and Password.");
        }
        else if (Authenticate.checkCredentials(usernameTextField.getText(), passwordField.getText())){
            if (CarbonBattles.getIngelogdeUser().isAdmin()){
                root = FXMLLoader.load(getClass().getResource("ManagerMenu.fxml"));
            }
            else {
                root = FXMLLoader.load(getClass().getResource("MedewerkerMenu.fxml"));
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("CarbonBattles");
            stage.setResizable(false);
            stage.show();

        }
        else {
            loginMessageLabel.setText("Incorrect credentials!");
        }
    }
}

