package com.example.carbonbattles.Models;

import java.util.Observable;

public class Rit {
    private int aantalKilometers;
    private Voertuig voertuig;
    private boolean elektrischOfNiet;
    private String datum;
    private String hoeWasDeRit;
    private String CO2_BewustheidRit;

    public Rit(int aantalKilometers, Voertuig voertuig, boolean elektrischOfNiet, String datum) {
        this.aantalKilometers = aantalKilometers;
        this.voertuig = voertuig;
        this.elektrischOfNiet = elektrischOfNiet;
        voertuig.setElektrischOfNiet(elektrischOfNiet);
        this.datum = datum;
    }

//    public int berekenAantalPunten() {
//        if (voertuig.berekenPunten(aantalKilometers, elektrischOfNiet) > 0) {
//            return voertuig.berekenPunten(aantalKilometers, elektrischOfNiet);
//        } else {
//            return 0;
//        }
//    }

    public int berekenAantalPunten() {
        if (voertuig.berekenPuntenMethod(aantalKilometers, elektrischOfNiet) > 0) {
            return voertuig.berekenPuntenMethod(aantalKilometers, elektrischOfNiet);
        } else {
            return 0;
        }
    }

    public double berekenAantalCO2Uitstoot() {
        if (voertuig.berekenCO2Uitstoot(aantalKilometers, elektrischOfNiet) > 0) {
            return voertuig.berekenCO2Uitstoot(aantalKilometers, elektrischOfNiet);
        } else {
            return 0;
        }
    }

    public String checkAantalKilometersPerRit() {
        if (aantalKilometers >= 50) {
            hoeWasDeRit = "Slechte Rit";
            return "Slechte Rit";
        } else if (aantalKilometers >= 30) {
            hoeWasDeRit = "Oke Rit";
            return "Oke Rit";
        } else if (aantalKilometers > 0) {
            hoeWasDeRit = "Goede Rit";
            return "Goede Rit";
        }
        hoeWasDeRit = "ERROR";
        return "ERROR";
    }

    public String checkCO2UitstootPerRit(double aantalCO2Rit){
        if (aantalCO2Rit >= 2500.0){
            CO2_BewustheidRit = "CO2 uitstoot zeer onbewuste rit";
        }
        else if (aantalCO2Rit >= 500.0){
            CO2_BewustheidRit = "CO2 uitstoot onbewuste rit";
        }
        else if (aantalCO2Rit >= 0.0){
            CO2_BewustheidRit = "CO2 uitstoot zeer bewuste rit";
        }
        return CO2_BewustheidRit;
    }

    public boolean getElektrischOfNiet() {
        return elektrischOfNiet;
    }

    public Voertuig getVoertuig() {
        return voertuig;
    }

    public int getAantalKilometers() {
        return aantalKilometers;
    }

    public String getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        return "Rit van " + datum + "           " + "+ " + berekenAantalPunten() + " Punten" + "   + " + berekenAantalCO2Uitstoot() + "g CO2 uitgestoten";
    }


}
