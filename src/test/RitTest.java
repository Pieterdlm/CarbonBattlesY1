import com.example.carbonbattles.Models.*;
import org.junit.Assert;
import org.junit.Test;


public class RitTest {

    @Test
    public void test_Auto() {
        Rit rit = new Rit(50, new Auto(), false, "01-01-2022");
        int actual = rit.berekenAantalPunten();
        Assert.assertEquals(100,actual);
    }

    @Test
    public void test_Fiets() {
        Rit rit = new Rit(10, new Fiets(), false, "01-01-2022");
        int actual = rit.berekenAantalPunten();
        Assert.assertEquals(500,actual);
    }

    @Test
    public void test_Trein() {
        Rit rit = new Rit(70, new Trein(), false, "01-01-2022");
        int actual = rit.berekenAantalPunten();
        Assert.assertEquals(70,actual);
    }

    @Test
    public void test_Scooter() {
        Rit rit = new Rit(10, new Scooter(), false, "01-01-2022");
        int actual = rit.berekenAantalPunten();
        Assert.assertEquals(270,actual);
    }
}
