package com.example.carbonbattles.Models;

public class Scooter extends Voertuig{

    public Scooter() {
        super("Scooter");

    }

//    @Override
//    public int berekenPunten(int kilometers, boolean elektrischOfNiet) {
//        if (elektrischOfNiet){
//            return 150 + (getBaseLinePunten() - (kilometers * 3));
//        }
//        return getBaseLinePunten() - (kilometers * 3);
//    }

    @Override
    int bepaalPuntenVoorVoertuig(int kilometers) {
        return getBaseLinePunten() - (kilometers * 3);
    }

    @Override
    int bepaalElektrischOfNiet(boolean elektrischOfNiet) {
        if(elektrischOfNiet){
            return 200;
        }
        return 0;
    }

    @Override
    public double berekenCO2Uitstoot(int kilometers, boolean elektrischOfNiet) {
        if (elektrischOfNiet){
            return 0;
        }
        return kilometers * 20.0;
    }
}
