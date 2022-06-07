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

public class InzichtPortaalController implements Initializable {

    @FXML
    private TableView<User> tabelUsers;
    @FXML
    private TableColumn<User, String> naamColumn;

    @FXML
    private TableColumn<User, Integer> puntenColumn;

    @FXML
    private TableColumn<User, Double> Co2Column;

    private static User clickedUser;

    ObservableList<User> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inzichtPortaal portaal = new inzichtPortaal();
        naamColumn.setCellValueFactory(new PropertyValueFactory<>("naam"));
        puntenColumn.setCellValueFactory(new PropertyValueFactory<>("aantalPunten"));
        Co2Column.setCellValueFactory(new PropertyValueFactory<>("aantalCO2Uitstoot"));
        ArrayList<User> AtotZ = portaal.getAtotZLijst();
        list.addAll(AtotZ);
        tabelUsers.setItems(list);
    }


    @FXML
    void buttonBekijkGegevens(ActionEvent event) throws IOException {
            clickedUser = tabelUsers.getSelectionModel().getSelectedItem();
            Parent root = FXMLLoader.load(getClass().getResource("infoSchermManager-view.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("CarbonBattles");
            stage.setResizable(false);
            stage.show();
        }


    @FXML
    void buttonBekijkAchievements(ActionEvent event) throws IOException {
        clickedUser = tabelUsers.getSelectionModel().getSelectedItem();
        Parent root = FXMLLoader.load(getClass().getResource("Achievements-admin-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CarbonBattles");
        stage.setResizable(false);
        stage.show();
    }

    public static User getClickedUser() {
        return clickedUser;
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
