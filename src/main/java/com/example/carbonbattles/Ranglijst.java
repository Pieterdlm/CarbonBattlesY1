package com.example.carbonbattles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class Ranglijst implements Initializable {

    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, String> naamColumn;
    @FXML
    private TableColumn<User, Integer> puntenColumn;
    private CarbonBattles lijst;
    private ArrayList<User> medewerkers;
    private ArrayList<User> top5 = new ArrayList<>();

    public Ranglijst(){
        lijst = new CarbonBattles();
        medewerkers = lijst.getUsers();
    }


    ObservableList<User> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        naamColumn.setCellValueFactory(new PropertyValueFactory<>("naam"));
        puntenColumn.setCellValueFactory(new PropertyValueFactory<>("aantalPunten"));
    }

    public void toonRanglijstMedewerkers() {
        for(int i=0;i<medewerkers.size()-1;i++){
            int m = i;
            for(int j=i+1;j<medewerkers.size();j++){
                if(medewerkers.get(m).getAantalPunten() < medewerkers.get(j).getAantalPunten())
                m = j;
            }
            //omruilen elementen positie i en m
            User temp = medewerkers.get(i);
            medewerkers.set(i, medewerkers.get(m));
            medewerkers.set(m, temp);

            list.addAll(medewerkers);
            tableView.setItems(list);
        }

    }

    public void toonRanglijstManager(){
        for(int i=0;i<medewerkers.size()-1;i++){
            int m = i;
            for(int j=i+1;j<medewerkers.size();j++){
                if(medewerkers.get(m).getAantalPunten() < medewerkers.get(j).getAantalPunten())
                    m = j;
            }
            //omruilen elementen positie i en m
            User temp = medewerkers.get(i);
            medewerkers.set(i, medewerkers.get(m));
            medewerkers.set(m, temp);
        }
        for (int i = 0; i < 4; i++) {
            top5.add(medewerkers.get(i));
        }
        list.addAll(top5);
        tableView.setItems(list);
    }
    
}
