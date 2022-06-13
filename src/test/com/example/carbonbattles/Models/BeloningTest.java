package com.example.carbonbattles.Models;

import org.junit.Assert;
import org.junit.Test;

public class BeloningTest {

    @Test
    public void BeloningPuntenTest_1000(){
        int expected = 1000;

        Medewerker dummy = new Medewerker("dummy" ,"dummy", "69");
        dummy.setAantalPunten(1100);
        dummy.createABeloning("dummy", "appel", 100,"dummyDatum");
        Assert.assertEquals(expected, dummy.getAantalPunten());
    }
}
