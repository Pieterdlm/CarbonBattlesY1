package com.example.carbonbattles.Models.Achievements;

import com.example.carbonbattles.CarbonBattles;

public class LangeWerkweek extends Achievement{
    private int waardeBehaald = 5;
    private int streak = 0;

    public LangeWerkweek(String naamAchievement) {
        super("Aantal keer gereisd");
    }

    @Override
    public boolean checkBehaald() {
        int indexLaatsteRit = CarbonBattles.getIngelogdeUser().getRitten().size() - 1;


        if (CarbonBattles.getIngelogdeUser().getRitten().get(indexLaatsteRit).getDatum().equals()){

        }
        return false;
    }

    @Override
    public void update() {
        CarbonBattles.getIngelogdeUser().checkAchievements(this);
    }
}
