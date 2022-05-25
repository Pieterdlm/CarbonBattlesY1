package com.example.carbonbattles.Models;

import java.util.Observable;

public class Rit{
    private int aantalKilometers;
    private Voertuig voertuig;
    private boolean elektrischOfNiet;
    private String datum;

    public Rit(int aantalKilometers, Voertuig voertuig, boolean elektrischOfNiet, String datum){
        this.aantalKilometers = aantalKilometers;
        this.voertuig = voertuig;
        this.elektrischOfNiet = elektrischOfNiet;
        voertuig.setElektrischOfNiet(elektrischOfNiet);
        this.datum = datum;
    }

    public int berekenAantalPunten(){
        if (voertuig.berekenPunten(aantalKilometers, elektrischOfNiet) > 0){
            return voertuig.berekenPunten(aantalKilometers,elektrischOfNiet);
        }else{
            return 0;
        }
    }

    public boolean getElektrischOfNiet(){
        return elektrischOfNiet;
    }

    public Voertuig getVoertuig(){
        return voertuig;
    }

    public int getAantalKilometers(){
        return aantalKilometers;
    }

    public String getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        return "Rit van " + datum + "           " + "+ " + berekenAantalPunten() + " Punten";
    }
}
