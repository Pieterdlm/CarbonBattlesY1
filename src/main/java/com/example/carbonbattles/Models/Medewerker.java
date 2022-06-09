package com.example.carbonbattles.Models;


import com.example.carbonbattles.Authenticate;
import com.example.carbonbattles.Models.Achievements.*;

import java.util.ArrayList;

public class Medewerker extends User implements IObservable {

    private final ArrayList<IObserver> observers = new ArrayList<>();
    private final ArrayList<Achievement> achievements = initializeAchievements();
    private String statusLaatsteRit;


    public Medewerker(String naam, String gebruikersnaam, String wachtwoord) {
        super(naam, gebruikersnaam, wachtwoord);
        setAdmin(false);
        observers.addAll(achievements);
    }


    @Override
    public void createARit(Integer kilometers, Voertuig voertuig, boolean elektrischOfNiet, String datum) {
        Rit rit = new Rit(kilometers, voertuig, elektrischOfNiet, datum);
        int aantalPunten = rit.berekenAantalPunten() + getAantalPunten();
        double aantalCO2 = rit.berekenAantalCO2Uitstoot() + getAantalCO2Uitstoot();
        setAantalPunten(aantalPunten);
        setCO2Uitstoot(aantalCO2);
        getRitten().add(rit);
        notifyObservers();
        statusChecker(rit);
    }

    public boolean statusChecker(Rit rit) {
        if (rit.getAantalKilometers() < 30 || rit.getElektrischOfNiet()) {
            statusLaatsteRit = "Goed Gedaan";
            return true;
        } else {
            statusLaatsteRit = "Kan Beter!";
        }
        return false;
    }

    public void notifyObservers() {
        for (IObserver o : observers) {
            o.update();
        }
    }

    @Override
    public void createABeloning(String redenVoorBeloning, String beloning, Integer nettoPuntenVerandering, String datum) {
        Beloning beloning1 = new Beloning(redenVoorBeloning, beloning, nettoPuntenVerandering, datum);
        setAantalPunten(getAantalPunten() - nettoPuntenVerandering);
        getBeloningen().add(beloning1);
    }

    @Override
    public void checkAchievements(Achievement achievement) {
        achievement.checkBehaald();
    }

    @Override
    public boolean veranderWachtwoord(String text) {
        if(Authenticate.checkWachtwoord(text)){
            setWachtwoord(text);
            return true;
        }
        return false;
    }


    public ArrayList<Achievement> initializeAchievements() {
        ArrayList<Achievement> lijst = new ArrayList<>();
        //Aanmaken van achievements voor Gebruikers
        lijst.add(new FietsAchievement());
        lijst.add(new treinTijger());
        lijst.add(new PuntaBit());
        lijst.add(new AantalKilometer());
        //lijst.add -> Andere achievements
        return lijst;
    }

    public ArrayList<Achievement> getAchievements() {
        return achievements;
    }


}
