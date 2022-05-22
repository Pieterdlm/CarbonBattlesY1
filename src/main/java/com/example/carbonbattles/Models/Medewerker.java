package com.example.carbonbattles.Models;

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
    public void createABeloning(String redenVoorBeloning, String beloning, Integer nettoPuntenVerandering, String datum){
        Beloning beloning1 = new Beloning(redenVoorBeloning, beloning, nettoPuntenVerandering, datum);
        setAantalPunten(getAantalPunten() - nettoPuntenVerandering);
        getBeloningen().add(beloning1);
    }
}
