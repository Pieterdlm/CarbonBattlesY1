package com.example.carbonbattles;

public class Auto extends Voertuig{

    public Auto() {
        super();
        setNaamVoertuig("Auto");
    }

    //Per Rit maximaal aantal punten ? En punten aftrekken naar mate meer kilometers ?
    @Override
    public int berekenPunten(int kilometers) {
            return getBaseLinePunten() - (kilometers * 4);
    }

}
