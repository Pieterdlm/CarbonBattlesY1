package com.example.carbonbattles;

import com.example.carbonbattles.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RanglijstView implements Initializable {

    @FXML
    private TableView<User> tabelUsers;
    @FXML
    private TableColumn<User, String> naamColumn;
    @FXML
    private TableColumn<User, Integer> puntenColumn;
    @FXML
    private TableColumn<User, Double> CO2Column;
    @FXML
    private Button backToMenu;
    private Scene scene;
    private Parent root;
    private Stage stage;

    private Ranglijst rang;

    ObservableList<User> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rang = new Ranglijst();

        naamColumn.setCellValueFactory(new PropertyValueFactory<>("naam"));
        puntenColumn.setCellValueFactory(new PropertyValueFactory<>("aantalPunten"));
        CO2Column.setCellValueFactory(new PropertyValueFactory<>("aantalCO2Uitstoot"));
        ArrayList<User> gesorteerdeLijst = rang.getGesorteerdeLijst();
        list.addAll(gesorteerdeLijst);
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
