package com.example.carbonbattles.Models;

import com.example.carbonbattles.CarbonBattles;
import com.example.carbonbattles.Models.Achievements.Achievement;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Manager extends User {

    public Manager(String naam, String gebruikersnaam, String wachtwoord) {
        super(naam, gebruikersnaam, wachtwoord);
        setAdmin(true);
    }

    @Override
    public ArrayList<Achievement> getAchievements() {
        return null;
    }

    @Override
    public void createARit(Integer kilometers, Voertuig voertuig, boolean elektrischOfNiet, String datum) {
    }

    @Override
    public void createABeloning(String redenVoorBeloning, String beloning, Integer nettoPuntenVerandering, String datum){
    }

    @Override
    public void checkAchievements(Achievement a) {
    }

    @Override
    public boolean veranderWachtwoord(String text) {
        return false;
    }

    @Override
    public String haalVoertuigNaamOpVanUser() {
        return null;
    }

    @Override
    public int haalKilometersOpVanLaatsteRit() {
        return 0;
    }


    public ArrayList<User> alleenMedewerkers() {
        ArrayList<User> alleMedewerkers = new ArrayList<>();
        for (User medewerker : CarbonBattles.getUsers()) {
            if (!medewerker.isAdmin()) {
                alleMedewerkers.add(medewerker);
            }
        }
        return alleMedewerkers;
    }
}