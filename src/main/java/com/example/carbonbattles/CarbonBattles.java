package com.example.carbonbattles;

import java.util.ArrayList;

public class CarbonBattles {
    private ArrayList<User> users = initList();

    private ArrayList<User> initList(){
        ArrayList<User> lijst= new ArrayList<>();
        lijst.add(new Medewerker("Adam", "696969", "Adam123", false, 3));
        return lijst;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
