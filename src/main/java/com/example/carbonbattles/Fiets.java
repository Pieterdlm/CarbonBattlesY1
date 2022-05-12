package com.example.carbonbattles;

public class Fiets extends Voertuig{

    public Fiets() {
        super();
        setNaamVoertuig("Fiets");
    }

    //Welke berekening voor fiets ? Geen CO2 dus geen punt aftrek maar standaard aantal terug geven ofso ?
    @Override
    public int berekenPunten(int kilometers) {
        return kilometers * 50;
    }
}
