package com.example.carbonbattles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WijzigWachtwoordController {

    @FXML
    private Button ChangeButton;

    @FXML
    private Label labelMessage;

    @FXML
    private TextField nieuweWachtwoordVeld;

    @FXML
    void changePassword(ActionEvent event) {
        if(!CarbonBattles.getIngelogdeUser().veranderWachtwoord(nieuweWachtwoordVeld.getText())){
            labelMessage.setText("Wachtwoord tenminste 8 karakters lang zijn!");
        }else {
            labelMessage.setText("Wachtwoord aangepast");
        }
    }

}
