package com.example.carbonbattles;

import com.example.carbonbattles.Models.User;


public class Authenticate extends CarbonBattles {


    public static boolean checkBlank(String gebruikersnaam, String wachtwoord) {
        return gebruikersnaam.isBlank() && wachtwoord.isBlank();
    }

    public static boolean checkWachtwoord(String ww){
        if(ww.length() < 8){
            return false;
        }return true;

    }
    public static boolean checkCredentials(String gebruikersnaam, String wachtwoord) {
        for (User u : CarbonBattles.getUsers()) {
            if (u.getGebruikersNaam().equals(gebruikersnaam)) {
                if (u.getWachtwoord().equals(wachtwoord)) {
                    setIngelogdeUser(u);
                    return true;
                }
            }
        }
        return false;
    }
}