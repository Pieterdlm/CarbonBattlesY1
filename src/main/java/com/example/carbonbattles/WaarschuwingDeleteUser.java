package com.example.carbonbattles;
import com.example.carbonbattles.Models.User;
import javafx.stage.Stage;

public class WaarschuwingDeleteUser {

    public WaarschuwingDeleteUser(){

    }
public static void delete(User medewerker){
    CarbonBattles.getUsers().remove(medewerker);

}







}
