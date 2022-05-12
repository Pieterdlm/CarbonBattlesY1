package com.example.carbonbattles;

public class Scooter extends Voertuig{

    public Scooter() {
        super();
        setNaamVoertuig("Scooter");
    }

    @Override
    public int berekenPunten(int kilometers) {
        return getBaseLinePunten() - (kilometers * 3);
    }
}
