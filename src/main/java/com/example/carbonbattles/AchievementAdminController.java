package com.example.carbonbattles;

import com.example.carbonbattles.Models.Achievements.*;
import com.example.carbonbattles.Models.LevelChecker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AchievementAdminController implements Initializable {

    @FXML
    private Button backToMenuButton;

    @FXML
    private ImageView fietsIcon;

    @FXML
    private ImageView kilometerIcon;

    @FXML
    private ImageView puntenIcon;

    @FXML
    private Label naamLabel;

    @FXML
    private ImageView treinIcon;

    private final ArrayList<Achievement> achievements = InzichtPortaalController.getClickedUser().getAchievements();

    @FXML
    void gaNaarMenuScherm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ManagerMenu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CarbonBattles");
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LevelChecker levelChecker = new LevelChecker();
        naamLabel.setText(InzichtPortaalController.getClickedUser().getNaam());
        for (Achievement a : achievements) {
            levelChecker.checkLevel(a, fietsIcon, treinIcon, puntenIcon, kilometerIcon);
        }
    }
}
