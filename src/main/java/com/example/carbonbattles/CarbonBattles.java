package com.example.carbonbattles;

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
        lijst.add(new Medewerker("Adam", "Adam123", "696969"));
        lijst.add(new Medewerker("Konrad", "Konrad123", "696969"));
        lijst.add(new Medewerker("Tarun", "Tarun123", "696969"));


        //Er moet mogelijkheid komen om van User te switchen om beide menus te tonen aan product owner!!!!

        //Manager Optie
        lijst.add(new Manager("Admin", "Admin", "123"));
        return lijst;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

}
