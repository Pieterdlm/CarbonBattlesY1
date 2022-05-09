package com.example.carbonbattles;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CarbonBattlesController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}