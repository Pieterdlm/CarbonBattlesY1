package com.example.carbonbattles;

public class Rit {
    private int aantalKilometers;
    private Voertuig voertuig;
    private boolean elektrischOfNiet;
    private String datum;

    public Rit(int aantalKilometers, Voertuig voertuig, boolean elektrischOfNiet, String datum){
        this.aantalKilometers = aantalKilometers;
        this.voertuig = voertuig;
        this.elektrischOfNiet = elektrischOfNiet;
        this.datum = datum;
    }

    public int berekenAantalPunten(){
        return voertuig.berekenPunten(aantalKilometers, elektrischOfNiet);
    }

    public boolean getElektrischOfNiet(){
        return elektrischOfNiet;
    }

    public String getDatum() {
        return datum;
    }
}
