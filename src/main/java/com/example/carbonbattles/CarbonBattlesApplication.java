package com.example.carbonbattles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class CarbonBattlesApplication extends Application {

    Stage stage = new Stage();

@Override
public void start(Stage stage2) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("BeherenUsers-view.fxml"));
    Scene scene = new Scene(root);
    stage.setTitle("CarbonBattles");
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}