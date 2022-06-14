package com.example.carbonbattles.Models.Achievements;

import com.example.carbonbattles.CarbonBattles;
import com.example.carbonbattles.Models.Achievements.Achievement;

public class AantalKilometer extends Achievement {
    private int aantalKilometer;
    private int kilometerGehaald = 250;

    @Override
    public boolean checkBehaald() {

        if (!CarbonBattles.haalLaatsteVoertuigNaamOpVanUser().equals("Auto")) {

            aantalKilometer= aantalKilometer + CarbonBattles.haalKilometersOpVanLaatstUitgevoerdeRit();
            if (aantalKilometer >= kilometerGehaald) {
                setBehaald(true);
                levelOpwaarderen();
                kilometerGehaald = kilometerGehaald * 2;
                System.out.println("Kilometer achievement behaald");
                System.out.println(currentLevel);
                return true;
            }
        }
        return false;
    }

    @Override
    public String setIcon() {
        if (currentLevel.toString().equals("Niet_Behaald")) {
            return "file:src/main/resources/com/example/carbonbattles/aantal km icon nog niet behaald.png";
        } else if (currentLevel.toString().equals("Bronze")) {
            return "file:src/main/resources/com/example/carbonbattles/aantal km icon brons.png";
        } else if (currentLevel.toString().equals("Silver")) {
            return "file:src/main/resources/com/example/carbonbattles/aantal km icon silver.png";
        } else if (currentLevel.toString().equals("Gold")) {
            return "file:src/main/resources/com/example/carbonbattles/aantal km icon gold.png";
        }
        return "No Value";
    }

    public AantalKilometer() {
        super("Aantal KM gemaakt.");
    }

    @Override
    public void update() {
        CarbonBattles.getIngelogdeUser().checkAchievements(this);
    }
}
