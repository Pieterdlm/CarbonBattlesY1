package com.example.carbonbattles;

import com.example.carbonbattles.CarbonBattles;
import com.example.carbonbattles.Models.Manager;
import com.example.carbonbattles.Models.Medewerker;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BeherenUsersController implements Initializable {

    // TableView items
    @FXML
    private TableView<User> WerknemersTableView;

    @FXML
    private TableColumn<User, String> naamColumn;

    @FXML
    private TableColumn<User, String> gebruikersNaamColumn;

    @FXML
    private TableColumn<User, Integer> puntenColumn;

    ObservableList<User> list = FXCollections.observableArrayList();


    //Invulvelden items
    @FXML
    private TextField inputGebruikersNaamField;

    @FXML
    private TextField inputNaamField;

    @FXML
    private TextField inputWachtwoordField;

    @FXML
    private CheckBox standaardWWCheckBox;

    Manager manager = new Manager("Admin", "admin", "admin");


    //Toont de tableview met de juiste colums en info
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        naamColumn.setCellValueFactory(new PropertyValueFactory<User, String>("naam"));
        gebruikersNaamColumn.setCellValueFactory(new PropertyValueFactory<User, String>("gebruikersNaam"));
        puntenColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("aantalPunten"));
        WerknemersTableView.setItems(list);
        list.addAll(manager.alleenMedewerkers());
    }


    // Gebeurt als je op de plus knop drukt
    @FXML
    void voegUserToe(MouseEvent event) {
        //User aanmaken en toevoegen aan arraylist
        UserToevoegen();

        // Testen of arraylist klopt. Print in de terminal  ------- Later verwijderen.
        for (User users : CarbonBattles.getUsers()){
            System.out.println(users.getNaam() + " - " + users.getGebruikersNaam() + " - " + users.getWachtwoord() + "");
        }
        System.out.println("------------------");

        //updaten van tableview
        WerknemersTableView.getItems().clear();
        list.addAll(manager.alleenMedewerkers());
        WerknemersTableView.setItems(list);


        //resetten van invulvelden
        inputNaamField.setText("");
        inputGebruikersNaamField.setText("");
        inputWachtwoordField.setText("");
    }


    //maakt user en stopt in arraylist van alleWerknemers
    private void UserToevoegen() {
        String naam = inputNaamField.getText();
        String gebruikersNaam = inputGebruikersNaamField.getText();
        String wachtwoord;
        if (!standaardWWCheckBox.isSelected()) {
            wachtwoord = inputWachtwoordField.getText();
        }
        else {wachtwoord = "welkom123";}
        ArrayList<User> alleWerknemers = CarbonBattles.getUsers();
        alleWerknemers.add(new Medewerker(naam, gebruikersNaam, wachtwoord));
    }


    //knop om terug te gaan naar het menu
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

}
