package com.example.carbonbattles;

public class Auto extends Voertuig{

    public Auto() {
        super();
        setNaamVoertuig("Auto");
    }

    //Per Rit maximaal aantal punten ? En punten aftrekken naar mate meer kilometers ?
    @Override
    public int berekenPunten(int kilometers, boolean elektrischOfNiet) {
        if (elektrischOfNiet){
            return 150 + (getBaseLinePunten() - (kilometers * 4));
        }
            return getBaseLinePunten() - (kilometers * 4);
    }

}
