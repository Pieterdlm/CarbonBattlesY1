package com.example.carbonbattles;

public class Rit {
    private int aantalKilometers;
    private Voertuig voertuig;

    public Rit(int aantalKilometers, Voertuig voertuig){
        this.aantalKilometers = aantalKilometers;
        this.voertuig = voertuig;
    }

    public int berekenAantalPunten(){
        return voertuig.berekenPunten(aantalKilometers);
    }
}
