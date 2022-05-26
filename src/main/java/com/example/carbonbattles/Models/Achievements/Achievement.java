package com.example.carbonbattles.Models.Achievements;

import com.example.carbonbattles.Models.IObserver;

import java.util.Observer;

public abstract class Achievement implements IObserver {
    private String naamAchievement;
    private boolean achievementGehaald;
    protected level currentLevel = level.Niet_Behaald;

    public void setAchievementGehaald(boolean achievementGehaald) {
        this.achievementGehaald = achievementGehaald;
    }

    public abstract boolean checkBehaald();

    protected enum level {Niet_Behaald, Bronze, Silver, Gold;}

    public Achievement(String naamAchievement) {
        this.naamAchievement = naamAchievement;
    }

    public void setCurrentLevel(level currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void levelOpwaarderen(){
        switch (currentLevel){
            case Niet_Behaald ->
                    setCurrentLevel(level.Bronze);
            case Bronze ->
                    setCurrentLevel(level.Silver);
            case Silver ->
                    setCurrentLevel(level.Gold);
        }
    }
}
