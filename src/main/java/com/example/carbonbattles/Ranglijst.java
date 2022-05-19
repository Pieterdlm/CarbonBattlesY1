package com.example.carbonbattles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class Ranglijst implements Initializable {

    @FXML
    private TableView<User> tabelUsers;
    @FXML
    private TableColumn<User, String> naamColumn;
    @FXML
    private TableColumn<User, Integer> puntenColumn;
    @FXML
    private Button backToMenu;
    private Scene scene;
    private Parent root;
    private Stage stage;

    private ArrayList<User> medewerkers = new ArrayList<>();

    public Ranglijst() {
        for (User u :CarbonBattles.getUsers()) {
                if (!u.isAdmin()){
                    medewerkers.add(u);
                }
        }
    }


    ObservableList<User> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        naamColumn.setCellValueFactory(new PropertyValueFactory<>("naam"));
        puntenColumn.setCellValueFactory(new PropertyValueFactory<>("aantalPunten"));
        toonRanglijstMedewerkers(medewerkers);

    }


    public void toonRanglijstMedewerkers(ArrayList<User> lijst) {
        for (int i = 0; i < lijst.size(); i++) {
            int m = i;
            for (int j = i + 1; j < lijst.size(); j++) {
                if (lijst.get(m).getAantalPunten() < lijst.get(j).getAantalPunten())
                    m = j;
            }


            //omruilen elementen positie i en m
            User temp = lijst.get(i);
            lijst.set(i, lijst.get(m));
            lijst.set(m, temp);


        }
        list.addAll(lijst);
        tabelUsers.setItems(list);
    }

    public void backButtonOnAction(ActionEvent event) throws IOException {
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
