package com.example.carbonbattles.Models.Achievements;

import com.example.carbonbattles.CarbonBattles;
import com.example.carbonbattles.Models.Achievements.Achievement;

public class AantalKilometer extends Achievement {
    private int aantalKilometer;
    private int kilometerGehaald = 250;

    @Override
    public boolean checkBehaald() {
        int aantalKilometers = CarbonBattles.getIngelogdeUser().getRitten().size() - 1;

        if (!CarbonBattles.getIngelogdeUser().getRitten().get(aantalKilometers).getVoertuig().getNaamVoertuig().equals("Auto")) {
            aantalKilometers = aantalKilometers + CarbonBattles.getIngelogdeUser().getRitten().get(aantalKilometers).getAantalKilometers();
            if (aantalKilometers == kilometerGehaald) {
                setBehaald(true);
                levelOpwaarderen();
                kilometerGehaald = kilometerGehaald * 2;
                System.out.println("Kilometer achievement behaald");
                System.out.println(currentLevel);
                return true;
            }
        } else {
            aantalKilometer = 0;
        }
        return false;
    }

    @Override
    public String setIcon() {
        if (currentLevel.toString().equals("Niet_Behaald")) {
            return "file:src/main/resources/com/example/carbonbattles/fiets icon.png";
        } else if (currentLevel.toString().equals("Bronze")) {
            return "file:src/main/resources/com/example/carbonbattles/fiets icon.png";
        } else if (currentLevel.toString().equals("Silver")) {
            return "file:src/main/resources/com/example/carbonbattles/silver-metallic.jpg";
        } else if (currentLevel.toString().equals("Gold")) {
            return "file:src/main/resources/com/example/carbonbattles/CarbonBattles.png";
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
