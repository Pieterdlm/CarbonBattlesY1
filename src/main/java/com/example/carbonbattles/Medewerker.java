package com.example.carbonbattles;

public class Medewerker extends User {

    public Medewerker(String naam, String gebruikersnaam, String wachtwoord, boolean isAdmin, int aantalPunten) {
        super(naam, gebruikersnaam, wachtwoord, isAdmin, aantalPunten);
    }

    @Override
    public void createARit(Integer kilometers, Voertuig voertuig) {
        Rit rit = new Rit(kilometers, voertuig);
        setAantalPunten(rit.berekenAantalPunten() + getAantalPunten());
        getRitten().add(rit);
    }

}
