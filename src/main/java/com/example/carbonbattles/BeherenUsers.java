package com.example.carbonbattles;

import com.example.carbonbattles.Models.Manager;
import com.example.carbonbattles.Models.Medewerker;
import com.example.carbonbattles.Models.User;

import java.util.ArrayList;

public class BeherenUsers {

    Manager manager = new Manager("Admin", "Admin", "Admin");

    public void userToevoegen(String naam, String gebruikersNaam, String wachtwoord){
        ArrayList<User> alleWerknemers = CarbonBattles.getUsers();
        alleWerknemers.add(new Medewerker(naam, gebruikersNaam, wachtwoord));
    }

    public boolean gebruikersNaamInUse(String gebruikersnaam) {
        boolean inGebruik = false;
        for (User users : manager.alleenMedewerkers()) {
            if (gebruikersnaam.equals(users.getGebruikersNaam())) {
                inGebruik = true;
            }
        }
        return inGebruik;
    }


}