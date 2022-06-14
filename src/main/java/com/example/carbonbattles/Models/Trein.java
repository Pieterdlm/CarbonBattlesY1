package com.example.carbonbattles.Models;

public class Trein extends Voertuig{

    public Trein() {
        super("Trein");

    }


    @Override
    int bepaalPuntenVoorVoertuig(int kilometers) {
        return kilometers;
    }

    @Override
    int bepaalElektrischOfNiet(boolean elektrischOfNiet) {
        return 0;
    }

    @Override
    public double berekenCO2Uitstoot(int kilometers, boolean elektrischOfNiet) {
        return 0;
    }
}
