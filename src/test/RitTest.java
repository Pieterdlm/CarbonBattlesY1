import com.example.carbonbattles.*;
import com.example.carbonbattles.Voertuig;
import org.junit.Assert;
import org.junit.Test;


public class RitTest {

    @Test
    public void test_Auto() {
        Rit rit = new Rit(50, new Auto());
        int actual = rit.berekenAantalPunten();
        Assert.assertEquals(100,actual);
    }

    @Test
    public void test_Fiets() {
        Rit rit = new Rit(10, new Fiets());
        int actual = rit.berekenAantalPunten();
        Assert.assertEquals(500,actual);
    }

    @Test
    public void test_Trein() {
        Rit rit = new Rit(70, new Trein());
        int actual = rit.berekenAantalPunten();
        Assert.assertEquals(70,actual);
    }

    @Test
    public void test_Scooter() {
        Rit rit = new Rit(10, new Scooter());
        int actual = rit.berekenAantalPunten();
        Assert.assertEquals(270,actual);
    }
}
