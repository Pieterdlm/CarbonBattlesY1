package com.example.carbonbattles.Models.Achievements;

import com.example.carbonbattles.CarbonBattles;
import com.example.carbonbattles.Models.Achievements.Achievement;

public class FietsAchievement extends Achievement {
    private int waardeBehaald = 5;
    public Integer streak = 0;

    public boolean checkBehaald() {
        int indexLaatsteRit = CarbonBattles.getIngelogdeUser().getRitten().size() - 1;

        if (CarbonBattles.getIngelogdeUser().getRitten().get(indexLaatsteRit).getVoertuig().getNaamVoertuig().equals("Fiets")) {
            streak++;

            if (streak == waardeBehaald) {
                setBehaald(true);
                levelOpwaarderen();
                waardeBehaald = waardeBehaald * 2;
                System.out.println("Fiets achievement behaald");
                System.out.println(currentLevel);
                return true;
            }
        }else {
            streak = 0;
        }
        return false;
    }

    public FietsAchievement() {
        super("Aantal keer gefietst");
    }


    @Override
    public void update() {
        CarbonBattles.getIngelogdeUser().checkAchievements(this);
    }
}
