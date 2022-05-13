package com.example.carbonbattles;

public class Trein extends Voertuig{

    public Trein() {
        super();
        setNaamVoertuig("Trein");
    }

    @Override
    public int berekenPunten(int kilometers, boolean elektrischOfNiet) {
        return kilometers;
    }
}
