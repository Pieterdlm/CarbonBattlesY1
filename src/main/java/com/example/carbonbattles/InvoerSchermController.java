package com.example.carbonbattles;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class InvoerSchermController {

    private CarbonBattles carbonbattle = new CarbonBattles();

    @FXML
    private ChoiceBox<Voertuig> boxKeuzes;


    @FXML
    private CheckBox elektrischCheckbox;

    @FXML
    private TextField kilometerVeld;

    @FXML
    void maakVoertuigElektrisch(ActionEvent event) {
    }

    @FXML
    void verzendGegevens(ActionEvent event) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();

        if (boxKeuzes.getSelectionModel().isEmpty()) {
            System.out.println("Niks geselecteerd");
        } else {
            if (kilometerVeld.getText().isEmpty()) {
                System.out.println("Niks ingevoerd");
            } else {

                Integer kilometers = Integer.parseInt(kilometerVeld.getText());
                Voertuig voertuig = boxKeuzes.getSelectionModel().getSelectedItem();

                //Maakt een Rit aan en geeft dit mee aan een gebruiker, moet nog een oplossing voor komen hoe je ingelogde user hier plaatst!!!
                carbonbattle.getUsers().get(0).createARit(kilometers, voertuig, elektrischCheckbox.isSelected(), dtf.format(now));

                //Test printen van het aantal punten van een rit
                System.out.println(carbonbattle.getUsers().get(0).getNaam() + " heeft "+
                                    carbonbattle.getUsers().get(0).getAantalPunten() + " punten ontvangen op " +
                                    carbonbattle.getUsers().get(0).getRitten().get(0).getDatum());
            }
        }
    }
}
