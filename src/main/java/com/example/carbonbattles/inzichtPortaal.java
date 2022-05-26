package com.example.carbonbattles;

import com.example.carbonbattles.Models.User;

import java.util.ArrayList;
import java.util.Comparator;

public class inzichtPortaal{


    private ArrayList<User> medewerkers = new ArrayList<>();
    private ArrayList<User> AtotZLijst;

    public inzichtPortaal() {
        for (User u :CarbonBattles.getUsers()) {
            if (!u.isAdmin()){
                medewerkers.add(u);
            }
        }
        AtotZLijst = lijstMedewerkersA_tot_Z(medewerkers);
    }

    public ArrayList<User> lijstMedewerkersA_tot_Z(ArrayList<User> lijst) {
        lijst.sort(Comparator.comparing(User::getNaam));
        return lijst;
    }

    public ArrayList<User> getAtotZLijst() {
        return AtotZLijst;
    }

}
