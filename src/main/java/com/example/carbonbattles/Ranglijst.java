package com.example.carbonbattles;

import com.example.carbonbattles.Models.*;
import java.util.ArrayList;


public class Ranglijst {

    private ArrayList<User> medewerkers = new ArrayList<>();
    private ArrayList<User> gesorteerdeLijst;
    public Ranglijst() {
        for (User u :CarbonBattles.getUsers()) {
                if (!u.isAdmin()){
                    medewerkers.add(u);
                }
        }
        gesorteerdeLijst = toonRanglijstMedewerkers(medewerkers);
    }

    public ArrayList<User> toonRanglijstMedewerkers(ArrayList<User> lijst) {
        for (int i = 0; i < lijst.size(); i++) {
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
        return lijst;
    }

    public ArrayList<User> getGesorteerdeLijst() {
        return gesorteerdeLijst;
    }
}
