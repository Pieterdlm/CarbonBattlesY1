import com.example.carbonbattles.Models.*;
import org.junit.Assert;
import org.junit.Test;


public class RitTest {

    @Test
    public void test_Auto() {
        Rit rit = new Rit(50, new Auto(), false, "01-01-2022");
        int actual = rit.berekenAantalPunten();
        Assert.assertEquals(100, actual);
    }

    @Test
    public void test_Fiets() {
        Rit rit = new Rit(10, new Fiets(), false, "01-01-2022");
        int actual = rit.berekenAantalPunten();
        Assert.assertEquals(500, actual);
    }

    @Test
    public void test_Trein() {
        Rit rit = new Rit(70, new Trein(), false, "01-01-2022");
        int actual = rit.berekenAantalPunten();
        Assert.assertEquals(70, actual);
    }

    @Test
    public void test_Scooter() {
        Rit rit = new Rit(10, new Scooter(), false, "01-01-2022");
        int actual = rit.berekenAantalPunten();
        Assert.assertEquals(270, actual);
    }

    @Test
    public void test_Auto_CO2Uitstoot() {
        Rit rit = new Rit(25, new Auto(), false, "01-02-2022");
        double actual = rit.berekenAantalCO2Uitstoot();
        Assert.assertEquals(3045.0, actual, 0.0001);
    }

    @Test
    public void test_Trein_CO2Uitstoot() {
        Rit rit = new Rit(15, new Trein(), false, "01-02-2022");
        double actual = rit.berekenAantalCO2Uitstoot();
        Assert.assertEquals(0.0, actual, 0.0001);
    }

    @Test
    public void test_Fiets_CO2Uitstoot() {
        Rit rit = new Rit(5, new Fiets(), false, "01-02-2022");
        double actual = rit.berekenAantalCO2Uitstoot();
        Assert.assertEquals(0.0, actual, 0.0001);
    }

    @Test
    public void test_Scooter_CO2Uitstoot() {
        Rit rit = new Rit(8, new Scooter(), false, "01-02-2022");
        double actual = rit.berekenAantalCO2Uitstoot();
        Assert.assertEquals(160.0, actual, 0.0001);
    }


    //CC
    @Test
    public void test_Condition_en_Decision_Coverage() {
        Medewerker user = new Medewerker("Dummy", "Dummy", "1234");
        Rit rit = new Rit(31, new Auto(), false, "01-02-2022");
        Assert.assertFalse(user.statusChecker(rit));

        Rit rit2 = new Rit(29, new Auto(), true, "01-02-2022");
        Assert.assertTrue(user.statusChecker(rit2));
    }

    //MCC
    @Test
    public void test_Multiple_Condition_Coverage() {
        Medewerker user = new Medewerker("Dummy", "Dummy", "1234");
        Rit rit = new Rit(31, new Auto(), false, "01-02-2022");
        Assert.assertFalse(user.statusChecker(rit));

        Rit rit2 = new Rit(31, new Auto(), true, "01-02-2022");
        Assert.assertTrue(user.statusChecker(rit2));

        Rit rit3 = new Rit(29, new Auto(), false, "01-02-2022");
        Assert.assertTrue(user.statusChecker(rit3));

        Rit rit4 = new Rit(29, new Auto(), true, "01-02-2022");
        Assert.assertTrue(user.statusChecker(rit4));
    }

    @Test
    public void equivalentieKlassenRitCheckKm() {
        Rit rit = new Rit(0, new Auto(), false, "01-02-2022");
        Assert.assertEquals("ERROR", rit.checkAantalKilometersPerRit());

        Rit rit2 = new Rit(1, new Auto(), false, "01-02-2022");
        Assert.assertEquals("Goede Rit", rit2.checkAantalKilometersPerRit());

        Rit rit3 = new Rit(29, new Auto(), false, "01-02-2022");
        Assert.assertEquals("Goede Rit", rit3.checkAantalKilometersPerRit());

        Rit rit4 = new Rit(30, new Auto(), false, "01-02-2022");
        Assert.assertEquals("Oke Rit", rit4.checkAantalKilometersPerRit());

        Rit rit5 = new Rit(31, new Auto(), false, "01-02-2022");
        Assert.assertEquals("Oke Rit", rit5.checkAantalKilometersPerRit());

        Rit rit6 = new Rit(49, new Auto(), false, "01-02-2022");
        Assert.assertEquals("Oke Rit", rit6.checkAantalKilometersPerRit());

        Rit rit7 = new Rit(50, new Auto(), false, "01-02-2022");
        Assert.assertEquals("Slechte Rit", rit7.checkAantalKilometersPerRit());

        Rit rit8 = new Rit(51, new Auto(), false, "01-02-2022");
        Assert.assertEquals("Slechte Rit", rit8.checkAantalKilometersPerRit());

}

    @Test
    public void equivalentieKlassenRitCheckCO2Uitstoot(){

        Rit rit = new Rit(15, new Fiets(), false, "02-03-2022");
        Assert.assertEquals("CO2 uitstoot zeer bewuste rit", rit.checkCO2UitstootPerRit(0));

        Rit rit2 = new Rit(1, new Scooter(), false, "02-03-2022");
        Assert.assertEquals("CO2 uitstoot zeer bewuste rit", rit2.checkCO2UitstootPerRit(0.01));

        Rit rit3 = new Rit(4, new Auto(), false, "02-03-2022");
        Assert.assertEquals("CO2 uitstoot zeer bewuste rit", rit3.checkCO2UitstootPerRit(499.99));

        Rit rit4 = new Rit(5,  new Auto(), false, "02-03-2022");
        Assert.assertEquals("CO2 uitstoot onbewuste rit", rit4.checkCO2UitstootPerRit(500.0));

        Rit rit5 = new Rit(5,  new Auto(), false, "02-03-2022");
        Assert.assertEquals("CO2 uitstoot onbewuste rit", rit5.checkCO2UitstootPerRit(500.01));

        Rit rit6 = new Rit(24,  new Auto(), false, "02-03-2022");
        Assert.assertEquals("CO2 uitstoot onbewuste rit", rit6.checkCO2UitstootPerRit(2499.0));

        Rit rit7 = new Rit(25,  new Auto(), false, "02-03-2022");
        Assert.assertEquals("CO2 uitstoot zeer onbewuste rit", rit7.checkCO2UitstootPerRit(2500.0));

        Rit rit8 = new Rit(25,  new Auto(), false, "02-03-2022");
        Assert.assertEquals("CO2 uitstoot zeer onbewuste rit", rit8.checkCO2UitstootPerRit(2500.01));

    }
}
