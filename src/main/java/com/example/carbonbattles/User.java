package com.example.carbonbattles;

import java.util.ArrayList;

public abstract class User {
    private String naam;
    private String wachtwoord;
    private String gebruikersNaam;
    private boolean isAdmin;
    private int aantalPunten;
    private ArrayList<Rit> ritten = new ArrayList<>();
    private ArrayList<Beloning> beloningen = new ArrayList<Beloning>();

    public User(String naam, String gebruikersnaam, String wachtwoord) {
        this.naam = naam;
        this.gebruikersNaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.isAdmin = isAdmin;
        this.aantalPunten = 0;
    }

    public String getNaam() {
        return naam;
    }

    public ArrayList<Rit> getRitten() {
        return ritten;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getGebruikersNaam() {
        return gebruikersNaam;
    }

    public void setGebruikersNaam(String gebruikersNaam) {
        this.gebruikersNaam = gebruikersNaam;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public int getAantalPunten() {
        return aantalPunten;
    }

    public void setAantalPunten(int aantalPunten) {
        this.aantalPunten = aantalPunten;
    }


    public abstract void showRanglijst();
    public abstract void createARit(Integer kilometers, Voertuig voertuig, boolean elektrischOfNiet, String datum);
}
