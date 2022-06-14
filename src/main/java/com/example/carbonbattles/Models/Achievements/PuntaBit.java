package com.example.carbonbattles.Models.Achievements;

import com.example.carbonbattles.CarbonBattles;

public class PuntaBit extends Achievement {

    private int waardeBehaald = 2500;

    public PuntaBit() {
        super("aantal punten behaald");
    }

    @Override
    public boolean checkBehaald() {

        if (CarbonBattles.getIngelogdeUser().getAantalPunten() >= waardeBehaald) {
            setBehaald(true);
            levelOpwaarderen();
            waardeBehaald = waardeBehaald * 2;
            System.out.println("PuntaBit achievement behaald");
            System.out.println(currentLevel);
            return true;
        }

        return false;
    }

    @Override
    public String setIcon() {
        if (currentLevel.toString().equals("Niet_Behaald")) {
            return "file:src/main/resources/com/example/carbonbattles/beker punten nog niet behaald.png";
        } else if (currentLevel.toString().equals("Bronze")) {
            return "file:src/main/resources/com/example/carbonbattles/beker punten brons.png";
        } else if (currentLevel.toString().equals("Silver")) {
            return "file:src/main/resources/com/example/carbonbattles/beker punten silver.png";
        } else if (currentLevel.toString().equals("Gold")) {
            return "file:src/main/resources/com/example/carbonbattles/beker punten gold.png";
        }
        return "No Value";
    }

    @Override
    public void update() {
        CarbonBattles.getIngelogdeUser().checkAchievements(this);
    }
}
