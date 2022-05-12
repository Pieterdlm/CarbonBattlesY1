package com.example.carbonbattles;

public class Manager extends User {

    public Manager(String naam, String gebruikersnaam, String wachtwoord, boolean isAdmin, int aantalPunten) {
        super(naam, gebruikersnaam, wachtwoord, isAdmin, aantalPunten);
    }

    @Override
    public void createARit(Integer kilometers, Voertuig voertuig) {

    }


}
