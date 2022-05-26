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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class dashboardView implements Initializable {

    @FXML
    private TableView<User> tabelUsers;
    @FXML
    private TableColumn<User, String> naamColumn;
    @FXML
    private TextField kenPuntenToe;
    @FXML
    private TextField beschrijvingBeloning;
    @FXML
    private TextField datum;
    @FXML
    private TextField redenVoorBeloning;
    @FXML
    private TableColumn<User, Integer> puntenColumn;

    private Dashboard dashboard;


    ObservableList<User> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dashboard = new Dashboard();
        naamColumn.setCellValueFactory(new PropertyValueFactory<>("naam"));
        puntenColumn.setCellValueFactory(new PropertyValueFactory<>("aantalPunten"));
        ArrayList<User> top5 = dashboard.getTop5();
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

    @FXML
    void buttonRewardEmployee(ActionEvent event) throws IOException {
        if(!(kenPuntenToe.getText().isBlank()|| beschrijvingBeloning.getText().isBlank() || redenVoorBeloning.getText().isBlank() || datum.getText().isBlank() )){
            int puntenAantal = getIntFromTextField(kenPuntenToe);
            String beloning = beschrijvingBeloning.getText();
            String naam = redenVoorBeloning.getText();
            String date = datum.getText();
            User clickedUser = tabelUsers.getSelectionModel().getSelectedItem();
            clickedUser.createABeloning(naam, beloning, puntenAantal, date);

            for ( int i = 0; i<tabelUsers.getItems().size(); i++) {
                tabelUsers.getItems().clear();
                break;
            }
            dashboard = new Dashboard();
            naamColumn.setCellValueFactory(new PropertyValueFactory<>("naam"));
            puntenColumn.setCellValueFactory(new PropertyValueFactory<>("aantalPunten"));
            ArrayList<User> top5 = dashboard.toonRanglijstManager(dashboard.getTop5());
            list.addAll(top5);
            tabelUsers.setItems(list);
        }

    }

    @FXML
    public static int getIntFromTextField(TextField textField) {
        String text = textField.getText();
        return Integer.parseInt(text);
    }

    @FXML
    void clickedRow(MouseEvent event) {
        User clickedUser = tabelUsers.getSelectionModel().getSelectedItem();
        redenVoorBeloning.setText(String.valueOf(clickedUser.getNaam()));
    }

}
