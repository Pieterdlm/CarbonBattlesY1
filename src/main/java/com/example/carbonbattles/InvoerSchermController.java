package com.example.carbonbattles;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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
    private TextField datumVeld;

    @FXML
    void gaNaarMenuScherm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MedewerkerMenu.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CarbonBattles");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void verzendGegevens(ActionEvent event) {
        if (boxKeuzes.getSelectionModel().isEmpty()) {
            System.out.println("Niks geselecteerd");
        } else {
            if (checkInputWaarden()) {
                System.out.println("ERROR");
            } else {

                Integer kilometers = Integer.parseInt(kilometerVeld.getText());
                Voertuig voertuig = boxKeuzes.getSelectionModel().getSelectedItem();

                //Maakt een Rit aan en geeft dit mee aan een gebruiker, moet nog een oplossing voor komen hoe je ingelogde user hier plaatst!!!
                carbonbattle.getUsers().get(0).createARit(kilometers, voertuig, elektrischCheckbox.isSelected(), datumVeld.getText());

                //Test printen van het aantal punten van een rit
                System.out.println(carbonbattle.getUsers().get(0).getNaam() + " heeft " +
                        carbonbattle.getUsers().get(0).getAantalPunten() + " punten ontvangen op " +
                        carbonbattle.getUsers().get(0).getRitten().get(0).getDatum());
            }
        }
    }

    private boolean checkInputWaarden() {
        return kilometerVeld.getText().isEmpty() || kilometerVeld.getText().equals("0") || datumVeld.getText().isEmpty() || kilometerVeld.getText().contains("-");
    }
}
