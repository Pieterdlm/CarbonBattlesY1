package com.example.carbonbattles.Models;

import com.example.carbonbattles.Models.Achievements.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LevelChecker {
    public void checkLevel(Achievement a, ImageView fietsIcon, ImageView treinIcon, ImageView puntenIcon, ImageView kilometerIcon) {
        if (a instanceof FietsAchievement) {
            fietsIcon.setImage(new Image(a.setIcon()));
        } else if (a instanceof treinTijger) {
            treinIcon.setImage(new Image(a.setIcon()));
        } else if (a instanceof PuntaBit) {
            puntenIcon.setImage(new Image(a.setIcon()));
        } else if (a instanceof AantalKilometer) {
            kilometerIcon.setImage(new Image(a.setIcon()));
        }
    }
}
