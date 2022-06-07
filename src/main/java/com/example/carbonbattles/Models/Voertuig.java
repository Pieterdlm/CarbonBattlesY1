package com.example.carbonbattles.Models;

public abstract class Voertuig {
    private String naamVoertuig;
    private boolean elektrischOfNiet;
    private final int baseLinePunten = 300;

    //public abstract int berekenPunten(int kilometers, boolean elektrischOfNiet);
    abstract int bepaalPuntenVoorVoertuig(int kilometers);
    abstract int bepaalElektrischOfNiet(boolean elektrischOfNiet);
    public abstract double berekenCO2Uitstoot(int kilometers, boolean elektrischOfNiet);

    //Mogelijke Template Method Pattern
    public int berekenPuntenMethod(int kilometers, boolean elektrischOfNiet){
        int temp = 0;
        temp += bepaalPuntenVoorVoertuig(kilometers);
        temp += bepaalElektrischOfNiet(elektrischOfNiet);
        return temp;
    }

    public Voertuig(String naamVoertuig) {
        this.naamVoertuig = naamVoertuig;
    }

    public boolean getElektrischOfNiet() {
        return elektrischOfNiet;
    }

    public void setElektrischOfNiet(boolean value) {
        elektrischOfNiet = value;
    }

    public String getNaamVoertuig() {
        return naamVoertuig;
    }

    public void setNaamVoertuig(String naamVoertuig) {
        this.naamVoertuig = naamVoertuig;
    }

    public String toString(){
        return getNaamVoertuig();
    }

    public int getBaseLinePunten() {
        return baseLinePunten;
    }
}
