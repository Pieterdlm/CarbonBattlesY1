package com.example.carbonbattles;

import com.example.carbonbattles.Models.Beloning;
import com.example.carbonbattles.Models.Rit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InfoSchermController implements Initializable {

    CarbonBattles carbonBattles = new CarbonBattles();


    @FXML
    private ListView<Rit> ListView;

    @FXML
    private ListView<Beloning> ListView1;

    @FXML
    private ImageView logo;

    @FXML
    private Text aantalTotalePunten = new Text();

    @FXML
    private TextArea myTextArea;

    @FXML
    private Text aantalCO2Uitgestoten;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Rit> ritten = CarbonBattles.getIngelogdeUser().getRitten();
        ArrayList<Beloning> belonings = CarbonBattles.getIngelogdeUser().getBeloningen();
        ListView.getItems().addAll(ritten);
        ListView1.getItems().addAll(belonings);
        logo.setVisible(true);

        int puntenVanIngelogdeUser = CarbonBattles.getIngelogdeUser().getAantalPunten();
        String puntentotaal = "" + puntenVanIngelogdeUser;

        double CO2UitstootVanIngelogdeUser = CarbonBattles.getIngelogdeUser().getAantalCO2Uitstoot();
        String CO2Totaal = "" + CO2UitstootVanIngelogdeUser;
        aantalTotalePunten.setText(puntentotaal);
        aantalCO2Uitgestoten.setText(CO2Totaal + "g");
    }

    @FXML
    private void displaySelected(MouseEvent event) {
        Rit rit = ListView.getSelectionModel().getSelectedItem();
        Beloning beloning = ListView1.getSelectionModel().getSelectedItem();

        if (rit == null && beloning == null) {
            myTextArea.setText("U heeft nog geen rit of beloning geselecteerd");
        } else {
            if (rit == null) {
                String reistext = "Op: " + beloning.getDatum() + " heeft u de beloning '" + beloning.getBeloning() + "' ontvangen.\nDit koste u " + beloning.getNettoPuntenVerandering()+ " punten";
                myTextArea.setText(reistext);
            } else {
                String reistext = "Op: " + rit.getDatum() + " heeft u " + rit.getAantalKilometers() + " kilometer gereisd met de " +
                        rit.getVoertuig() + ".\nU kreeg voor deze rit " + rit.berekenAantalPunten() + " punten" + ".\nU heeft voor deze rit " + rit.berekenAantalCO2Uitstoot() + "g CO2 uitgestoten." +
                        ".\nDit was een " + rit.checkCO2UitstootPerRit(rit.berekenAantalCO2Uitstoot());
                myTextArea.setText(reistext);
            }
        }
    }
    @FXML
    void gaTerugNaarMenu(ActionEvent event) throws IOException {
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
    void wijzigWachtwoord(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WijzigWachtwoord-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("CarbonBattles");
        stage.show();
    }
}


