package com.example.carbonbattles;

import com.example.carbonbattles.Models.Manager;
import com.example.carbonbattles.Models.Medewerker;
import com.example.carbonbattles.Models.User;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

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

    //looks
    @FXML
    private ImageView plusButtonImageView;

    @FXML
    private Rectangle rectangle;

    public static User clickedUser;

    //Invulvelden items
    @FXML
    private TextField inputGebruikersNaamField;

    @FXML
    private TextField inputNaamField;

    @FXML
    private TextField inputWachtwoordField;

    @FXML
    private CheckBox standaardWWCheckBox;

    @FXML
    private Label errorMessage;

    Manager manager = new Manager("Admin", "admin", "admin");
    BeherenUsers beherenUsers = new BeherenUsers();

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


        if (!checkCredentials() && !beherenUsers.gebruikersNaamInUse(gebruikersNaam)) {
            //Wachtwoord instellen
            if (!standaardWWCheckBox.isSelected()) {
                wachtwoord = inputWachtwoordField.getText();
            } else {
                inputWachtwoordField.setText("");
                wachtwoord = "welkom123";
            }
            beherenUsers.userToevoegen(naam, gebruikersNaam, wachtwoord);
            toevoegenGelukt();
        }
        else
        {

            toevoegenNietGelukt();
            if (beherenUsers.gebruikersNaamInUse(gebruikersNaam)) {
                errorMessage.setText("Kies een andere gebruikersnaam");
                System.out.println("Niet correcte naam");
            } else {
                errorMessage.setText("Vul alle velden in");
                System.out.println("niet alle velden ingevuld");
            }
        }
    }

    //Maakt rectangle groen en roteert de plus knop als toevoegen is gelukt.
    public void toevoegenGelukt() {
        FillTransition fillTransition = new FillTransition(Duration.millis(600), rectangle);
        fillTransition.setToValue(Color.web("#a7e99c"));
        fillTransition.setCycleCount(2);
        fillTransition.setAutoReverse(true);
        fillTransition.play();

        RotateTransition rotate = new RotateTransition();
        rotate.setNode(plusButtonImageView);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(180);
        rotate.play();

        errorMessage.setText("");
    }

    //Maakt rectangle rood als toevoegen niet is gelukt
    public void toevoegenNietGelukt() {
        FillTransition fillTransition = new FillTransition(Duration.millis(600), rectangle);
        fillTransition.setToValue(Color.web("#FF8A8A"));
        fillTransition.setCycleCount(2);
        fillTransition.setAutoReverse(true);
        fillTransition.play();
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


    @FXML
    void deleteUserTrashcan(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WarningScreenUserDelete.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("CarbonBattles");
        stage.show();
        clickedUser = WerknemersTableView.getSelectionModel().getSelectedItem();

    }


    public static User getClickedUser() {
        return clickedUser;
    }

    @FXML
    void refreshButton(MouseEvent event) {
        WerknemersTableView.getItems().clear();
        list.addAll(manager.alleenMedewerkers());
        WerknemersTableView.setItems(list);
    }

    //Checkt of de invulvelden zijn ingevuld.
    public boolean checkCredentials() {
        return inputNaamField.getText().isEmpty() || inputGebruikersNaamField.getText().isEmpty() || (inputWachtwoordField.getText().isEmpty() && !standaardWWCheckBox.isSelected());
    }
}
