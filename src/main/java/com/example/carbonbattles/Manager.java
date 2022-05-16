package com.example.carbonbattles;

public class Manager extends User {

    public Manager(String naam, String gebruikersnaam, String wachtwoord, boolean isAdmin) {
        super(naam, gebruikersnaam, wachtwoord, true);
    }

    @Override
    public void createARit(Integer kilometers, Voertuig voertuig) {

    }


}
