package com.example.carbonbattles;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class WaarschuwingDeleteUserController {
    @FXML
    private Button cancelbutton;


    @FXML
    void cancelButton(MouseEvent event) throws IOException {
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void deleteUser(MouseEvent event) throws IOException {
        CarbonBattles.getUsers().remove(BeherenUsersController.getClickedUser());
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();


    }



}
