import com.example.carbonbattles.CarbonBattles;
import com.example.carbonbattles.Models.*;
import org.junit.Assert;
import org.junit.Test;

public class AchievementTest {

    @Test
    public void checkFietsAchievement_BijVijfKeerAchterElkaarMetFiets_Behaald() {
        Medewerker user = new Medewerker("Dummy","Dumm123", "Dummy123");
        CarbonBattles.setIngelogdeUser(user);

        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");

        Assert.assertFalse(user.getAchievements().get(0).checkBehaald());

        user.createARit(1, new Auto(), false, "01-01-0101");

        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        Assert.assertTrue(user.getAchievements().get(0).checkBehaald());

    }
}
