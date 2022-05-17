package com.example.carbonbattles;

public class Medewerker extends User {

    public Medewerker(String naam, String gebruikersnaam, String wachtwoord) {
        super(naam, gebruikersnaam, wachtwoord);
        setAdmin(false);
    }

    @Override
    public void createARit(Integer kilometers, Voertuig voertuig, boolean elektrischOfNiet, String datum) {
        Rit rit = new Rit(kilometers, voertuig, elektrischOfNiet, datum);
        setAantalPunten(rit.berekenAantalPunten() + getAantalPunten());
        getRitten().add(rit);
    }

    @Override
    public void showRanglijst() {
        Ranglijst rang  = new Ranglijst();
        rang.toonRanglijstMedewerkers();

    }

}
