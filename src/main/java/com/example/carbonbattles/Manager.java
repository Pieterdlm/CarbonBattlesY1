package com.example.carbonbattles;

public class Manager extends User {

    public Manager(String naam, String gebruikersnaam, String wachtwoord) {
        super(naam, gebruikersnaam, wachtwoord);
        setAdmin(true);
    }

    @Override
    public void createARit(Integer kilometers, Voertuig voertuig, boolean elektrischOfNiet, String datum) {

    }

    @Override
    public void showRanglijst() {
        Ranglijst rang  = new Ranglijst();
        rang.toonRanglijstManager();
    }
}
