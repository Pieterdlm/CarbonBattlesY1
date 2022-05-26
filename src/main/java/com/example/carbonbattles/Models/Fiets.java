package com.example.carbonbattles.Models;

public class Fiets extends Voertuig{

    public Fiets() {
        super("Fiets");
    }

    @Override
    public int berekenPunten(int kilometers, boolean elektrischOfNiet) {
        return kilometers * 50;
    }

    @Override
    public double berekenCO2Uitstoot(int kilometers, boolean elektrischOfNiet) {
        return 0;
    }
}
