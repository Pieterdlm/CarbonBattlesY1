package com.example.carbonbattles.Models;

public class Auto extends Voertuig{

    public Auto() {
        super("Auto");
    }


    @Override
    int bepaalPuntenVoorVoertuig(int kilometers) {
        return (getBaseLinePunten() - (kilometers * 4));
    }

    @Override
    int bepaalElektrischOfNiet(boolean elektrischOfNiet) {
        if(elektrischOfNiet){
            return 150;
        }
        return 0;
    }

    @Override
    public double berekenCO2Uitstoot(int kilometers, boolean elektrischOfNiet) {
        if (elektrischOfNiet){
            return 0;
        }
        return kilometers * 121.8;
    }
}
