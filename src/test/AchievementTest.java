import com.example.carbonbattles.CarbonBattles;
import com.example.carbonbattles.Models.*;
import org.junit.Assert;
import org.junit.Test;

public class AchievementTest {

    @Test
    public void checkFietsAchievement_BijVijfKeerAchterElkaarMetFiets_Behaald() {
        User user1 = new Medewerker("Dummy","Dumm123", "Dummy123");
        CarbonBattles.setIngelogdeUser(user1);
        User user = CarbonBattles.getIngelogdeUser();

        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");

        user.createARit(1, new Auto(), false, "01-01-0101");

        Assert.assertFalse(user.getAchievements().get(0).isBehaald());

        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        Assert.assertTrue(user.getAchievements().get(0).isBehaald());
    }

    @Test
    public void checkFietsAchievement_Bij10KeerAchterElkaarMetFiets_Behaald_Silver() {
        User user1 = new Medewerker("Dummy","Dumm123", "Dummy123");
        CarbonBattles.setIngelogdeUser(user1);
        User user = CarbonBattles.getIngelogdeUser();

        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");

        user.createARit(1, new Auto(), false, "01-01-0101");

        Assert.assertFalse(user.getAchievements().get(0).isBehaald());

        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        user.createARit(1, new Fiets(), false, "01-01-0101");
        Assert.assertTrue(user.getAchievements().get(0).getCurrentLevel().equals("Silver"));
    }
}
