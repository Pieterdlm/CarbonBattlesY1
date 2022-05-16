package com.example.carbonbattles;

import java.util.ArrayList;
import java.util.Collections;

public class Ranglijst {
    private CarbonBattles lijst;
    private ArrayList<User> medewerkers;

    public Ranglijst(){
        lijst = new CarbonBattles();
        medewerkers = lijst.getUsers();
    }


    public void toonRanglijstMedewerkers() {
        for(int i=0;i<medewerkers.size()-1;i++){
            int m = i;
            for(int j=i+1;j<medewerkers.size();j++){
                if(medewerkers.get(m).getAantalPunten() < medewerkers.get(j).getAantalPunten())
                m = j;
            }
            //omruilen elementen positie i en m
            User temp = medewerkers.get(i);
            medewerkers.set(i, medewerkers.get(m));
            medewerkers.set(m, temp);
        }

        //System.out.println(medewerkers)
    }

    public void toonRanglijstManager(){

    }
}
