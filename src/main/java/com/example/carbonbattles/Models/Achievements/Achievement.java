package com.example.carbonbattles.Models.Achievements;

import com.example.carbonbattles.Models.IObserver;

import java.util.Observer;

public abstract class Achievement implements IObserver {
    private String naamAchievement;
    private boolean behaald;
    protected level currentLevel = level.Niet_Behaald;


    public abstract boolean checkBehaald();

    public abstract String setIcon();

    protected enum level {Niet_Behaald, Bronze, Silver, Gold;}


    public Achievement(String naamAchievement) {
        this.naamAchievement = naamAchievement;
    }

    public void setCurrentLevel(level currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void setBehaald(boolean behaald) {
        this.behaald = behaald;
    }

    public String getCurrentLevel() {
        return currentLevel.toString();
    }
    public boolean isBehaald(){
        return behaald;
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
