package com.example.carbonbattles;

public class Scooter extends Voertuig{

    public Scooter() {
        super();
        setNaamVoertuig("Scooter");
    }

    @Override
    public int berekenPunten(int kilometers, boolean elektrischOfNiet) {
        if (elektrischOfNiet){
            return 150 + (getBaseLinePunten() - (kilometers * 3));
        }
        return getBaseLinePunten() - (kilometers * 3);
    }
}
