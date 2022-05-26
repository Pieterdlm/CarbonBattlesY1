package com.example.carbonbattles.Models;

public class Manager extends User {

    public Manager(String naam, String gebruikersnaam, String wachtwoord) {
        super(naam, gebruikersnaam, wachtwoord);
        setAdmin(true);
    }

    @Override
    public void createARit(Integer kilometers, Voertuig voertuig, boolean elektrischOfNiet, String datum) {
    }

    @Override
    public void createABeloning(String redenVoorBeloning, String beloning, Integer nettoPuntenVerandering, String datum){
    }

}