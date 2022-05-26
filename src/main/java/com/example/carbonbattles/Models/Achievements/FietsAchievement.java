package com.example.carbonbattles.Models.Achievements;

import com.example.carbonbattles.CarbonBattles;
import com.example.carbonbattles.Models.Achievements.Achievement;

public class FietsAchievement extends Achievement {
    private int waardeBehaald = 5;

    public boolean checkBehaald() {
        int streak = 0;
        for(int i = 0; i < CarbonBattles.getIngelogdeUser().getRitten().size(); i++){
            if(CarbonBattles.getIngelogdeUser().getRitten().get(i).getVoertuig().getNaamVoertuig().equals("Fiets")) {
                streak++;
            }else{
                streak = 0;
            }
                if(streak == waardeBehaald){
                    System.out.println("Fiets achievement behaald");
                    setAchievementGehaald(true);
                    return true;
                }
        }
        levelOpwaarderen();
        waardeBehaald = waardeBehaald * 2;
        setAchievementGehaald(false);
        return false;
    }

    public FietsAchievement() {
        super("Aantal keer gefietst");
    }


    @Override
    public void update() {
        CarbonBattles.getIngelogdeUser().checkAchievements();
    }
}
