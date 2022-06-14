package com.example.carbonbattles;
import com.example.carbonbattles.Models.User;

public class WaarschuwingDeleteUser {

    public WaarschuwingDeleteUser(){

    }
    
    //verwijderd een medewerker uit de lijst van medewerkers
public static void delete(User medewerker){
    CarbonBattles.getUsers().remove(medewerker);

}







}
