package com.example.carbonbattles.Models;

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

    public String getDatum() {
        return datum;
    }

    public String getBeloning() {
        return Beloning;
    }

    public Integer getNettoPuntenVerandering() {
        return nettoPuntenVerandering;
    }

    @Override
    public String toString() {
        return "Beloning gekregen op: " + datum + "           " + "- " + nettoPuntenVerandering.toString() + " Punten";
    }
}
