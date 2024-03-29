package com.example.carbonbattles;

import com.example.carbonbattles.Models.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {


    @FXML
    private Button invoerButton;
    @FXML
    private Button rangLijstButton;
    @FXML
    private Button mijnnfoButton;
    private Scene scene;
    private Parent root;
    private Stage stage;

    @FXML
    private Button achievementsButton;


    @FXML
    void achievementSwitch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Achievements-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CarbonBattles");
        stage.setResizable(false);
        stage.show();
    }

    public void invoerSwitchOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InvoerScherm-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        ChoiceBox<Voertuig> box = (ChoiceBox<Voertuig>) scene.lookup("#boxKeuzes");
        box.setItems(FXCollections.observableArrayList(new Auto(), new Fiets(), new Trein(), new Scooter()));
        stage.setScene(scene);
        stage.setTitle("CarbonBattles");
        stage.setResizable(false);
        stage.show();
    }

    public void rangLijstSwitchOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RangLijst.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CarbonBattles");
        stage.setResizable(false);
        stage.show();
    }

    public void mijnInfoSwitchOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InfoScherm.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CarbonBattles");
        stage.setResizable(false);
        stage.show();
    }

    public void dashBoardSwitchOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CarbonBattles");
        stage.setResizable(false);
        stage.show();
    }

    public void signOutOnSwitch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Auth.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CarbonBattles");
        stage.setResizable(false);
        stage.show();

    }
    public void inzichtSwitchOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InzichtPortaal-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CarbonBattles");
        stage.setResizable(false);
        stage.show();
    }

    public void invoerMedewerkerSwitchOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BeherenUsers-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CarbonBattles");
        stage.setResizable(false);
        stage.show();
    }


}
