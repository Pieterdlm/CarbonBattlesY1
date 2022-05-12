package com.example.carbonbattles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class InvoerSchermController {

    private Voertuig voertuig;
    //private User medewerker;

    @FXML
    private ChoiceBox<Voertuig> boxKeuzes;

    @FXML
    private CheckBox autoCheckBox;

    @FXML
    private CheckBox elektrischCheckbox;

    @FXML
    private CheckBox fietsCheckBox;

    @FXML
    private TextField kilometerVeld;

    @FXML
    private CheckBox scooterCheckBox;

    @FXML
    private CheckBox treinCheckBox;

    @FXML
    private Button verzendButton;

    @FXML
    void maakVoertuigElektrisch(ActionEvent event) {
    }

    @FXML
    void verzendGegevens(ActionEvent event) {
        int aantalBehaaldePunten = 0;

        if (boxKeuzes.getSelectionModel().isEmpty()) {
            System.out.println("Niks geselecteerd");
        } else {
            if (kilometerVeld.getText().isEmpty()) {
                System.out.println("Niks ingevoerd");
            } else {
                if (elektrischCheckbox.isSelected()) {
                    aantalBehaaldePunten += 1000;
                }
                Integer kilometers = Integer.parseInt(kilometerVeld.getText());
                Voertuig x = boxKeuzes.getSelectionModel().getSelectedItem();
                aantalBehaaldePunten += x.berekenPunten(kilometers);
                System.out.println(aantalBehaaldePunten);
            }
        }
    }
}
