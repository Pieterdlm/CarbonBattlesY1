package com.example.carbonbattles;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CarbonBattlesApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CarbonBattlesApplication.class.getResource("InvoerScherm-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 300);

        //ChoiceBoxVervoersmiddel Toevoegen
        ChoiceBox<Voertuig> box = (ChoiceBox<Voertuig>) scene.lookup("#boxKeuzes");
        box.setItems(FXCollections.observableArrayList(new Auto(), new Fiets(), new Trein(), new Scooter()));

        //ChoiceBoxDagen toevoegen
        ChoiceBox<String> box2 = (ChoiceBox<String>) scene.lookup("#boxKeuzesDag");
        box2.setItems(FXCollections.observableArrayList("Maandag", "Dinsdag", "Woensdag", "Donderdag", "Vrijdag"));

       // FXMLLoader fxmlLoader = new FXMLLoader(CarbonBattlesApplication.class.getResource("Dashboard-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}