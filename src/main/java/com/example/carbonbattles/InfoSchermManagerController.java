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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InfoSchermManagerController implements Initializable {

    @FXML
    private javafx.scene.control.ListView<Rit> ListViewRitten;

    @FXML
    private ListView<Beloning> ListViewBeloning;

    @FXML
    private ImageView logo;

    @FXML
    private Text aantalPunten = new Text();

    @FXML
    private Text aantalCO2Uitstoot = new Text();


    @FXML
    private TextArea text;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<Rit> ritten = InzichtPortaalController.getClickedUser().getRitten();
        ArrayList<Beloning> belonings = InzichtPortaalController.getClickedUser().getBeloningen();
        ListViewRitten.getItems().addAll(ritten);
        ListViewBeloning.getItems().addAll(belonings);
        logo.setVisible(true);

        double CO2UitstootVanGekozenMedewerker = InzichtPortaalController.getClickedUser().getAantalCO2Uitstoot();
        String CO2totaal = "" + CO2UitstootVanGekozenMedewerker;

        int puntenVanGekozenMedewerker = InzichtPortaalController.getClickedUser().getAantalPunten();
        String puntentotaal = "" + puntenVanGekozenMedewerker;
        aantalPunten.setText(puntentotaal);
        aantalCO2Uitstoot.setText(CO2totaal + "g");
    }

    @FXML
    private void displaySelected(MouseEvent event) {
        Rit rit = ListViewRitten.getSelectionModel().getSelectedItem();
        Beloning beloning = ListViewBeloning.getSelectionModel().getSelectedItem();

        if (rit == null && beloning == null) {
            text.setText("U heeft nog geen rit of beloning geselecteerd");
        }
        else{
            if (rit == null){
                String reistext = "Op: " + beloning.getDatum() + " heeft " + InzichtPortaalController.getClickedUser().getNaam() +  " de beloning '" + beloning.getBeloning() +
                        "' ontvangen.\nDit koste " + InzichtPortaalController.getClickedUser().getNaam() + " " + beloning.getNettoPuntenVerandering()+ " punten";
                text.setText(reistext);
            }
            else{
                String reisText = "Op: " + rit.getDatum() + " heeft " + InzichtPortaalController.getClickedUser().getNaam() + " " + rit.getAantalKilometers() + " kilometer gereisd met de " +
                        rit.getVoertuig() + ".\n" + InzichtPortaalController.getClickedUser().getNaam() +  " kreeg voor deze rit " + rit.berekenAantalPunten() + " punten" +
                        ".\n" + InzichtPortaalController.getClickedUser().getNaam() + " heeft voor deze rit " + rit.berekenAantalCO2Uitstoot() + "g CO2 uitgestoten." +
                        ".\nDit was een " + rit.checkCO2UitstootPerRit(rit.berekenAantalCO2Uitstoot());

                text.setText(reisText);
            }
        }
        }
    @FXML
    void gaTerugNaarLijst(ActionEvent event) throws IOException {
        if (CarbonBattles.getIngelogdeUser().isAdmin()) {
            Parent root = FXMLLoader.load(getClass().getResource("InzichtPortaal-view.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("CarbonBattles");
            stage.setResizable(false);
            stage.show();
        }
    }

    @FXML
    void gaTerugNaarMenu(ActionEvent event) throws IOException {
        if (CarbonBattles.getIngelogdeUser().isAdmin()) {
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
}
