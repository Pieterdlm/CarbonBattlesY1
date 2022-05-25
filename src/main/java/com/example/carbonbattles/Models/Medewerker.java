package com.example.carbonbattles.Models;



import java.util.ArrayList;
import java.util.Observer;

public class Medewerker extends User implements IObservable {

    private ArrayList<IObserver> observers = new ArrayList<>();
    private ArrayList<Achievement> achievements = initializeAchievements();



    public Medewerker(String naam, String gebruikersnaam, String wachtwoord) {
        super(naam, gebruikersnaam, wachtwoord);
        setAdmin(false);
        observers.add(new FietsAchievement());
    }

    @Override
    public void createARit(Integer kilometers, Voertuig voertuig, boolean elektrischOfNiet, String datum) {
        Rit rit = new Rit(kilometers, voertuig, elektrischOfNiet, datum);
        setAantalPunten(rit.berekenAantalPunten() + getAantalPunten());
        getRitten().add(rit);
        notifyObservers();
    }

    public void notifyObservers() {
        for(IObserver o : observers){
            o.update();
        }
    }

    @Override
    public void createABeloning(String redenVoorBeloning, String beloning, Integer nettoPuntenVerandering, String datum){
        Beloning beloning1 = new Beloning(redenVoorBeloning, beloning, nettoPuntenVerandering, datum);
        setAantalPunten(getAantalPunten() - nettoPuntenVerandering);
        getBeloningen().add(beloning1);
    }

    @Override
    public void checkAchievements() {
        for(Achievement achievement : achievements){
            achievement.checkBehaald();
        }
    }


    public ArrayList<Achievement> initializeAchievements() {
        ArrayList<Achievement> lijst = new ArrayList<>();
        //Aanmaken van achievements voor Gebruikers
        lijst.add(new FietsAchievement());
        //lijst.add -> Andere achievements
        return lijst;
    }

    public ArrayList<Achievement> getAchievements() {
        return achievements;
    }
}
