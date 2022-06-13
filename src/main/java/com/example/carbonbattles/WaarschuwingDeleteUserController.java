package com.example.carbonbattles;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class WaarschuwingDeleteUserController {

@FXML
Button cancelbutton;

    @FXML
//zorgt ervoor dat waarschuwingscherm wordt geclosed
    void cancelButton(MouseEvent event) throws IOException {
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }

    @FXML
    //zodra er op deze knop wordt gedrukt wordt de methode in de controller class gebruikt die de medewerker verwijderdt.
    void deleteUser(MouseEvent event) throws IOException {
        WaarschuwingDeleteUser.delete(BeherenUsersController.getClickedUser());
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();


    }
}
