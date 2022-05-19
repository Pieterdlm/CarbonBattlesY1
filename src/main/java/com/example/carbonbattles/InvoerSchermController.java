package com.example.carbonbattles;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
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
    private Button verzendButton;

    @FXML
    private TextField datumVeld;

    @FXML
    private Label infoShower;

    @FXML
    void gaNaarMenuScherm(ActionEvent event) throws IOException {
        if (CarbonBattles.getUsers().get(0).isAdmin()) {
            Parent root = FXMLLoader.load(getClass().getResource("ManagerMenu.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("CarbonBattles");
            stage.setResizable(false);
            stage.show();
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("MedewerkerMenu.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("CarbonBattles");
            stage.setResizable(false);
            stage.show();
        }
    }

    @FXML
    void verzendGegevens(ActionEvent event) {
        if (boxKeuzes.getSelectionModel().isEmpty()) {
            infoShower.setText("Niks geselecteerd");
        } else {
            if (checkInputWaarden()) {
                infoShower.setText("ERROR");
            } else {
                verzendButton.setStyle("-fx-background-color: #24a0ed; ");
                verzendButton.setText("<<Verzonden>>");

                Integer kilometers = Integer.parseInt(kilometerVeld.getText());
                Voertuig voertuig = boxKeuzes.getSelectionModel().getSelectedItem();

                CarbonBattles.getIngelogdeUser().createARit(kilometers, voertuig
                                                 , elektrischCheckbox.isSelected()
                                                  , datumVeld.getText());

                //Test printen van het aantal punten van een rit (Verwijder na afronden Sprint)
                System.out.println(CarbonBattles.getIngelogdeUser().getNaam() + " heeft " +
                        CarbonBattles.getIngelogdeUser().getAantalPunten() + " punten ontvangen op " +
                        CarbonBattles.getIngelogdeUser().getRitten().get(g));
            }
        }
    }

    private boolean checkInputWaarden() {
        return kilometerVeld.getText().isEmpty()
                || kilometerVeld.getText().equals("0")
                || datumVeld.getText().isEmpty()
                || kilometerVeld.getText().contains("-");
    }
}
