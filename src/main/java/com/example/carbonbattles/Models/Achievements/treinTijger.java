package com.example.carbonbattles.Models.Achievements;

import com.example.carbonbattles.CarbonBattles;
import com.example.carbonbattles.Models.*;

import java.util.ArrayList;

public class treinTijger extends Achievement {

    private int aantalKilometers = 0;
    private int waardeBehaald = 200;

    public treinTijger() {
        super("Aantal kilometer met de trein");
    }

    @Override
    public boolean checkBehaald() {
        int indexLaatsteRit = CarbonBattles.getIngelogdeUser().getRitten().size() - 1;

        if (CarbonBattles.getIngelogdeUser().getRitten().get(indexLaatsteRit).getVoertuig().getNaamVoertuig().equals("Trein")) {
            aantalKilometers = aantalKilometers + CarbonBattles.getIngelogdeUser().getRitten().get(indexLaatsteRit).getAantalKilometers();

            if (aantalKilometers >= waardeBehaald) {
                setBehaald(true);
                levelOpwaarderen();
                waardeBehaald = waardeBehaald * 2;
                System.out.println("Trein achievement behaald");
                System.out.println(currentLevel);
                return true;
            }
        }
        return false;
    }

    @Override
    public String setIcon() {
        if (currentLevel.toString().equals("Niet_Behaald")) {
            return "file:src/main/resources/com/example/carbonbattles/trein nog niet behaald.png";
        } else if (currentLevel.toString().equals("Bronze")) {
            return "file:src/main/resources/com/example/carbonbattles/trein brons.png";
        } else if (currentLevel.toString().equals("Silver")) {
            return "file:src/main/resources/com/example/carbonbattles/trein silver.png";
        } else if (currentLevel.toString().equals("Gold")) {
            return "file:src/main/resources/com/example/carbonbattles/trein gold.png";
        }
        return "No Value";
    }


    @Override
    public void update() {
        CarbonBattles.getIngelogdeUser().checkAchievements(this);
    }
}
