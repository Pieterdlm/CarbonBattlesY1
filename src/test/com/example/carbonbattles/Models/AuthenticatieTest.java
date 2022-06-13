package com.example.carbonbattles.Models;

import com.example.carbonbattles.CarbonBattles;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticatieTest {

    @Test
    public void wachtwoordCheckerTest_minderdan8karakters(){
        CarbonBattles.setIngelogdeUser(new Medewerker("dummy", "dummy", "welkom12"));
        String oudWachtwoord = CarbonBattles.getIngelogdeUser().getWachtwoord();

        //Asserts of de methode false terug geeft bij het checken van het wachtwoord
        Assert.assertFalse(CarbonBattles.getIngelogdeUser().veranderWachtwoord("1234567"));
        String nieuwWachtwoord = CarbonBattles.getIngelogdeUser().getWachtwoord();

        //Asserts of het nieuwe wachtwoord is veranderd
        Assert.assertEquals(oudWachtwoord,nieuwWachtwoord);
    }

    @Test
    public void wachtwoordCheckerTest_8karakters(){
        CarbonBattles.setIngelogdeUser(new Medewerker("dummy", "dummy", "welkom12"));
        String oudWachtwoord = CarbonBattles.getIngelogdeUser().getWachtwoord();

        Assert.assertTrue(CarbonBattles.getIngelogdeUser().veranderWachtwoord("12345678"));
        String nieuwWachtwoord = CarbonBattles.getIngelogdeUser().getWachtwoord();
        Assert.assertNotEquals(oudWachtwoord,nieuwWachtwoord);
    }

    @Test
    public void wachtwoordCheckerTest_meerdan8karakters(){
        CarbonBattles.setIngelogdeUser(new Medewerker("dummy", "dummy", "welkom12"));
        String oudWachtwoord = CarbonBattles.getIngelogdeUser().getWachtwoord();

        Assert.assertTrue(CarbonBattles.getIngelogdeUser().veranderWachtwoord("123456789"));
        String nieuwWachtwoord = CarbonBattles.getIngelogdeUser().getWachtwoord();
        Assert.assertNotEquals(oudWachtwoord,nieuwWachtwoord);
    }

    @Test
    public void wachtwoordCheckerTest_0karakters(){
        CarbonBattles.setIngelogdeUser(new Medewerker("dummy", "dummy", "welkom12"));
        String oudWachtwoord = CarbonBattles.getIngelogdeUser().getWachtwoord();

        Assert.assertFalse(CarbonBattles.getIngelogdeUser().veranderWachtwoord(""));
        String nieuwWachtwoord = CarbonBattles.getIngelogdeUser().getWachtwoord();
        Assert.assertEquals(oudWachtwoord,nieuwWachtwoord);
    }
}
