package com.example.carbonbattles;

import com.example.carbonbattles.Models.User;

import java.util.ArrayList;
import com.example.carbonbattles.Models.*;

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

//methode voor het omruilen van punten voor een beloning, die door de admin wordt toegekend
    public int substractPoints(int punten, User user){
        if(user.getAantalPunten()==0){
            return user.getAantalPunten();
        }
        else if(user.getAantalPunten()<punten){
            return user.getAantalPunten();
        }
        return user.getAantalPunten() - punten;
    }


}
