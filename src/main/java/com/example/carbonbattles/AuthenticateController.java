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

public class AuthenticateController extends CarbonBattles {


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
        for (User u : CarbonBattles.getUsers()) {
            if (u.getGebruikersNaam().equals(usernameTextField.getText().toString())) {
                if (u.getWachtwoord().equals(passwordField.getText().toString())) {
                    Parent root;
                    if (u.isAdmin()) {
                        root = FXMLLoader.load(getClass().getResource("ManagerMenu.fxml"));

                    } else {
                        root = FXMLLoader.load(getClass().getResource("MedewerkerMenu.fxml"));
                    }
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("CarbonBattles");
                    stage.setResizable(false);
                    stage.show();
                } else {
                    loginMessageLabel.setText("Incorrect credentials!");
                }
            }
            else if (usernameTextField.getText().isBlank() && passwordField.getText().isBlank()){
                loginMessageLabel.setText("Please enter your Username and Password.");
            }
            else {
                loginMessageLabel.setText("Incorrect credentials!");
            }
        }
    }
}
//        if(usernameTextField.getText().toString().equals(CarbonBattles.getUsers().contains(usernameTextField.getText())) && passwordField.getText().toString().equals(getUsers().contains(usernameTextField.getText()))) {
//            loginMessageLabel.setText("Succes!");
//            if (getUsers().contains(isAdmin))   {
//                Parent root = FXMLLoader.load(getClass().getResource("MedewerkerMenu.fxml"));
//                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//                scene = new Scene(root);
//                stage.setScene(scene);
//                stage.setTitle("CarbonBattles");
//                stage.setResizable(false);
//                stage.show();
//            }
//            else{
//                Parent root = FXMLLoader.load(getClass().getResource("ManagerMenu.fxml"));
//                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//                scene = new Scene(root);
//                stage.setScene(scene);
//                stage.setTitle("CarbonBattles");
//                stage.setResizable(false);
//                stage.show();
//            }
//        }
//        else if (usernameTextField.getText().isBlank() == true && passwordField.getText().isBlank() == true){
//            loginMessageLabel.setText("Please enter your Username and Password.");
//        }
//        else{
//            loginMessageLabel.setText("Incorrect credentials!");
//        }
//    }

