package com.example.carbonbattles;

import com.example.carbonbattles.Models.Achievements.*;
import com.example.carbonbattles.Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AchievementController implements Initializable {

    @FXML
    private Button backToMenuButton;

    @FXML
    private ImageView fietsIcon;

    @FXML
    private ImageView kilometerIcon;

    @FXML
    private ImageView puntenIcon;

    @FXML
    private ImageView treinIcon;

    private final ArrayList<Achievement> achievements = CarbonBattles.getIngelogdeUser().getAchievements();

    @FXML
    void gaNaarMenuScherm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MedewerkerMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CarbonBattles");
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Achievement a : achievements) {
            checkLevel(a);
        }
    }

    //Nachecken Hoe je per Subclass de Icon aanpast van de bijbehorende Class
    private void checkLevel(Achievement a) {
        if (a instanceof FietsAchievement) {
            fietsIcon.setImage(new Image(a.setIcon()));
        } else if (a instanceof treinTijger) {
            treinIcon.setImage(new Image(a.setIcon()));
        } else if (a instanceof PuntaBit) {
            puntenIcon.setImage(new Image(a.setIcon()));
        } else if (a instanceof AantalKilometer) {
            kilometerIcon.setImage(new Image(a.setIcon()));
        }
    }
}
