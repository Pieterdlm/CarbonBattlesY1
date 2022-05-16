package com.example.carbonbattles;

public class Medewerker extends User {

    public Medewerker(String naam, String gebruikersnaam, String wachtwoord, boolean isAdmin) {
        super(naam, gebruikersnaam, wachtwoord, false);
    }

    @Override
    public void createARit(Integer kilometers, Voertuig voertuig) {
        Rit rit = new Rit(kilometers, voertuig);
        setAantalPunten(rit.berekenAantalPunten() + getAantalPunten());
        getRitten().add(rit);
    }

    @Override
    public void showRanglijst() {
        Ranglijst rang  = new Ranglijst();
        rang.toonRanglijstMedewerkers();

    }

}
