package com.example.carbonbattles;

import java.util.ArrayList;

public class CarbonBattles {
    private static ArrayList<User> users = initList();

    private static ArrayList<User> initList(){
        ArrayList<User> lijst= new ArrayList<>();
        //Manager Optie
        lijst.add(new Manager("Adam", "Adam123", "696969"));

        //Er moet mogelijkheid komen om van User te switchen om beide menus te tonen aan product owner!!!!

        //Medewerker Optie
        //lijst.add(new Manager("Adam", "Adam123", "696969"));
        return lijst;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

}
