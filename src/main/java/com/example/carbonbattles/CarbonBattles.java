package com.example.carbonbattles;

import java.util.ArrayList;

public class CarbonBattles {
    private static ArrayList<User> users = initList();

    private static ArrayList<User> initList(){
        ArrayList<User> lijst= new ArrayList<>();
        lijst.add(new Medewerker("Adam", "Adam123", "696969", true));
        return lijst;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

}
