package com.example.carbonbattles;

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

    private CarbonBattles lijst;
    private ArrayList<User> medewerkers;
    private ArrayList<User> top5 = new ArrayList<>();

    public Ranglijst(){
        medewerkers = CarbonBattles.getUsers();
        for (int i = 0; i < medewerkers.size(); i++) {
            if (medewerkers.get(i).isAdmin()){
                medewerkers.remove(i);
            }
        }
    }


    ObservableList<User> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        naamColumn.setCellValueFactory(new PropertyValueFactory<>("naam"));
        puntenColumn.setCellValueFactory(new PropertyValueFactory<>("aantalPunten"));
            if(CarbonBattles.getIngelogdeUser().isAdmin()){
                toonRanglijstManager();
            }
            else{
                toonRanglijstMedewerkers();
            }
        }


    public void toonRanglijstMedewerkers() {
        for(int i=0;i<medewerkers.size();i++){
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
        list.addAll(medewerkers);
        tabelUsers.setItems(list);
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
        for (int i = 0; i < 5; i++) {
            top5.add(medewerkers.get(i));

        }
        list.addAll(top5);
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
