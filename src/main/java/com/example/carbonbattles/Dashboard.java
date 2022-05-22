package com.example.carbonbattles;

import com.example.carbonbattles.Models.User;

import java.util.ArrayList;

public class Dashboard {

    private ArrayList<User> medewerkers = new ArrayList<>();
    private ArrayList<User> top5;


    public Dashboard() {
        for (User u :CarbonBattles.getUsers()) {
            if (!u.isAdmin()){
                medewerkers.add(u);
            }
        }
        top5 = toonRanglijstManager(medewerkers);

    }

    public ArrayList<User> toonRanglijstManager(ArrayList<User> lijst) {
        ArrayList<User> top5Lijst = new ArrayList<>();
        for (int i = 0; i < lijst.size() - 1; i++) {
            int m = i;
            for (int j = i + 1; j < lijst.size(); j++) {
                if (lijst.get(m).getAantalPunten() < lijst.get(j).getAantalPunten())
                    m = j;
            }
            //omruilen elementen positie i en m
            User temp = lijst.get(i);
            lijst.set(i, lijst.get(m));
            lijst.set(m, temp);
        }
        for (int i = 0; i < 5; i++) {
            top5Lijst.add(lijst.get(i));
        }
        return top5Lijst;
    }

    public ArrayList<User> getTop5() {
        return top5;
    }
}
