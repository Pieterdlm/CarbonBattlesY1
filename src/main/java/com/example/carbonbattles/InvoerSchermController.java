package com.example.carbonbattles;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class InvoerSchermController {

    private CarbonBattles carbonbattle = new CarbonBattles();

    @FXML
    private ChoiceBox<Voertuig> boxKeuzes;

    @FXML
    private ChoiceBox<String> boxKeuzesDag;

    @FXML
    private CheckBox elektrischCheckbox;

    @FXML
    private TextField kilometerVeld;

    @FXML
    private Button verzendButton;

    @FXML
    void maakVoertuigElektrisch(ActionEvent event) {
    }

    @FXML
    void verzendGegevens(ActionEvent event) {
        int aantalBehaaldePunten = 0;

        if (boxKeuzes.getSelectionModel().isEmpty() || boxKeuzesDag.getSelectionModel().isEmpty()) {
            System.out.println("Niks geselecteerd");
        } else {
            if (kilometerVeld.getText().isEmpty()) {
                System.out.println("Niks ingevoerd");
            } else {
                if (elektrischCheckbox.isSelected()) {
                    aantalBehaaldePunten += 1000;
                }
                Integer kilometers = Integer.parseInt(kilometerVeld.getText());
                Voertuig voertuig = boxKeuzes.getSelectionModel().getSelectedItem();

                carbonbattle.getUsers().get(0).createARit(kilometers, voertuig);
                System.out.println(carbonbattle.getUsers().get(0).getAantalPunten());
            }
        }
    }
}
