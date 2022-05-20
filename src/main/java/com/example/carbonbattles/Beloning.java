package com.example.carbonbattles;

public class Beloning {
    private String naam;
    private String Beloning;
    private Integer nettoPuntenVerandering;
    private String datum;

    public Beloning(String naam, String beloning, Integer nettoPuntenVerandering, String datum) {
        this.naam = naam;
        Beloning = beloning;
        this.nettoPuntenVerandering = nettoPuntenVerandering;
        this.datum = datum;
    }

    public String toString() {
        return "Rit van " + datum + "           " + "+ " + nettoPuntenVerandering + " Punten";
    }
}
