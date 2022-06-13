package com.example.carbonbattles;
import com.example.carbonbattles.Models.*;

import java.util.ArrayList;

public class CarbonBattles {
    private static ArrayList<User> users = initList();
    private static User ingelogdeUser;

    public static void setIngelogdeUser(User user) {
        ingelogdeUser = user;
    }

    public static User getIngelogdeUser() {
        return ingelogdeUser;
    }

    private static ArrayList<User> initList(){
        ArrayList<User> lijst= new ArrayList<>();
        //Medewerker Optie
        lijst.add(new Medewerker("Adam", "Adam1234", "696969"));
        lijst.add(new Medewerker("Tarun", "Tarun123", "696969"));
        lijst.add(new Medewerker("Tarun3", "Dummy123", "696969"));
        lijst.add(new Medewerker("Tarun4", "Rob123", "696969"));
        lijst.add(new Medewerker("Tarun5", "Piet123", "696969"));
        lijst.add(new Medewerker("Konrad", "Konrad123", "696969"));


        //Manager Optie
        lijst.add(new Manager("Admin", "Admin", "123"));
        return lijst;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static String haalLaatsteVoertuigNaamOpVanUser() {
        return ingelogdeUser.haalVoertuigNaamOpVanUser();
    }
}
