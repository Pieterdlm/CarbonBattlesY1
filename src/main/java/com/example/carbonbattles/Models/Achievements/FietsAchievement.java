package com.example.carbonbattles.Models.Achievements;

import com.example.carbonbattles.CarbonBattles;
import com.example.carbonbattles.Models.Achievements.Achievement;

public class FietsAchievement extends Achievement {
    private int waardeBehaald = 5;
    public Integer streak = 0;

    public boolean checkBehaald() {

        if (CarbonBattles.haalLaatsteVoertuigNaamOpVanUser().equals("fiets")) {
            streak++;

            if (streak == waardeBehaald) {
                setBehaald(true);
                levelOpwaarderen();
                waardeBehaald = waardeBehaald * 2;
                System.out.println("Fiets achievement behaald");
                System.out.println(currentLevel);
                return true;
            }
        } else {
            streak = 0;
        }
        return false;
    }

    @Override
    public String setIcon() {

        if (currentLevel.toString().equals("Niet_Behaald")) {
            return "file:src/main/resources/com/example/carbonbattles/fiets icon nog niet behaald.png";
        } else if (currentLevel.toString().equals("Bronze")) {
            return "file:src/main/resources/com/example/carbonbattles/fiets icon.png";
        } else if (currentLevel.toString().equals("Silver")) {
            return "file:src/main/resources/com/example/carbonbattles/fiets icon  silver.png";
        } else if (currentLevel.toString().equals("Gold")) {
            return "file:src/main/resources/com/example/carbonbattles/gold fiets icon.png";
        } else {
            return "No Value";
        }
    }

    public FietsAchievement() {
        super("Aantal keer gefietst");
    }


    @Override
    public void update() {
        CarbonBattles.getIngelogdeUser().checkAchievements(this);
    }
}
