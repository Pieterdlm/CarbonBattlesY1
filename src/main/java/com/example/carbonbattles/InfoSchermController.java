package com.example.carbonbattles;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
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
    private Text MijnInfo;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView logo;

    @FXML
    private Text aantalTotalePunten = new Text();

    @FXML
    private TextArea myTextArea;

    @FXML
    private Rectangle rectanglePunten;

    @FXML
    private Button backToMenuButton = new Button();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Rit> ritten = CarbonBattles.getIngelogdeUser().getRitten();
        ListView.getItems().addAll(ritten);
        logo.setVisible(true);

        int puntenVanIngelogdeUser = CarbonBattles.getIngelogdeUser().getAantalPunten();
        String puntentotaal = "" + puntenVanIngelogdeUser;
        aantalTotalePunten.setText(puntentotaal);
    }

    @FXML
    private void displaySelected(MouseEvent event) {
        Rit rit = ListView.getSelectionModel().getSelectedItem();

        if (rit == null) {
            myTextArea.setText("U heeft nog geen rit geselecteerd");
        } else {

            String reistext = "Op: " + rit.getDatum() + " heeft u " + rit.getAantalKilometers() + " kilometer gereisd met de " +
                    rit.getVoertuig() + ".\nU kreeg voor deze rit " + rit.berekenAantalPunten() + " punten." ;

              myTextArea.setText(reistext);
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
}


