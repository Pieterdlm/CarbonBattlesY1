package com.example.carbonbattles.Models;

public class Trein extends Voertuig{

    public Trein() {
        super("Trein");

    }

    @Override
    public int berekenPunten(int kilometers, boolean elektrischOfNiet) {
        return kilometers;
    }
}
