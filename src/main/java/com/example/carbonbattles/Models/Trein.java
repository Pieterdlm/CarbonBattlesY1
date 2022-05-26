package com.example.carbonbattles.Models;

public class Trein extends Voertuig{

    public Trein() {
        super("Trein");

    }

    @Override
    public int berekenPunten(int kilometers, boolean elektrischOfNiet) {
        return kilometers;
    }

    @Override
    public double berekenCO2Uitstoot(int kilometers, boolean elektrischOfNiet) {
        if (elektrischOfNiet){
            return 0;
        }
        return kilometers * 0.75;
    }
}
