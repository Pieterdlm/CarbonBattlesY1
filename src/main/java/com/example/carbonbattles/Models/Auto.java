package com.example.carbonbattles.Models;

public class Auto extends Voertuig{

    public Auto() {
        super("Auto");
    }

    //Per Rit maximaal aantal punten ? En punten aftrekken naar mate meer kilometers ?
    @Override
    public int berekenPunten(int kilometers, boolean elektrischOfNiet) {
        if (elektrischOfNiet){
            return 150 + (getBaseLinePunten() - (kilometers * 4));
        }
            return getBaseLinePunten() - (kilometers * 4);
    }

    @Override
    public double berekenCO2Uitstoot(int kilometers, boolean elektrischOfNiet) {
        if (elektrischOfNiet){
            return 0;
        }
        return kilometers * 121.8;
    }

}
