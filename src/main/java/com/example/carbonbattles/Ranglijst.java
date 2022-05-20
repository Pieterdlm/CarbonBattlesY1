package com.example.carbonbattles;

import com.example.carbonbattles.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
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


public class Ranglijst {

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
    private ArrayList<User> gesorteerdeLijst;
    public Ranglijst() {
        for (User u :CarbonBattles.getUsers()) {
                if (!u.isAdmin()){
                    medewerkers.add(u);
                }
        }
        gesorteerdeLijst = toonRanglijstMedewerkers(medewerkers);
    }

    public ArrayList<User> toonRanglijstMedewerkers(ArrayList<User> lijst) {
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
        return lijst;
    }

    public ArrayList<User> getGesorteerdeLijst() {
        return gesorteerdeLijst;
    }
}
