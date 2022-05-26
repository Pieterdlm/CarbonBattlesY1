package com.example.carbonbattles.Models;

import java.util.ArrayList;

public abstract class User {
    private String naam;
    private String wachtwoord;
    private String gebruikersNaam;
    private boolean isAdmin;
    private int aantalPunten;
    private double aantalCO2Uitstoot;
    private ArrayList<Rit> ritten = new ArrayList<>();
    private ArrayList<Beloning> beloningen = new ArrayList<>();

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

    public void setCO2Uitstoot(double aantalCO2Uitstoot){
        this.aantalCO2Uitstoot = aantalCO2Uitstoot;
    }

    public ArrayList<Beloning> getBeloningen(){return beloningen;};

    public abstract void createARit(Integer kilometers, Voertuig voertuig, boolean elektrischOfNiet, String datum);

    public abstract void createABeloning(String redenVoorBeloning, String beloning, Integer nettoPuntenVerandering, String datum);

    public abstract void checkAchievements();


    public double getCO2Uitstoot() {
        return aantalCO2Uitstoot;
    }

}
