package com.example.carbonbattles;

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

public class dashboardView implements Initializable {

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


    public dashboardView() {
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
        ArrayList<User> top5 = toonRanglijstManager(medewerkers);
        list.addAll(top5);
        tabelUsers.setItems(list);
    }



    public ArrayList<User> toonRanglijstManager(ArrayList<User> lijst) {
        ArrayList<User> top5Lijst = new ArrayList<>();
        for (int i = 0; i < lijst.size() - 1; i++) {
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
        for (int i = 0; i < 5; i++) {
            top5Lijst.add(lijst.get(i));
        }
        return top5Lijst;
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
