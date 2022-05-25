package com.example.carbonbattles.Models;

import com.example.carbonbattles.CarbonBattles;

public class FietsAchievement extends Achievement{

    public boolean checkBehaald() {
        int streak = 0;
        for(int i = 0; i < CarbonBattles.getIngelogdeUser().getRitten().size(); i++){
            if(CarbonBattles.getIngelogdeUser().getRitten().get(i).getVoertuig().getNaamVoertuig().equals("Fiets")) {
                streak++;
            }else{
                streak = 0;
            }
                if(streak == 5){
                    System.out.println("Fiets achievement behaald");
                    setAchievementGehaald(true);
                    return true;
                }
        }
        currentLevel = level.Bronze;
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
