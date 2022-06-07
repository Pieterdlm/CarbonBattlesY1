import com.example.carbonbattles.BeherenUsers;
import com.example.carbonbattles.CarbonBattles;
import com.example.carbonbattles.Models.Manager;
import com.example.carbonbattles.Models.Medewerker;
import com.example.carbonbattles.Models.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BeherenUsersTest {

    @Test
    void userToevoegen() {
        BeherenUsers beheer = new BeherenUsers();
        ArrayList<User> alleWerknemers = CarbonBattles.getUsers();

        int medewerkersVoorToevoeging = alleWerknemers.size();
        System.out.println(alleWerknemers.size());

        beheer.userToevoegen("Test", "Test", "Test");

        int medewerkersNaToevoeging = alleWerknemers.size();
        System.out.println(alleWerknemers.size());

        assertEquals(medewerkersNaToevoeging - medewerkersVoorToevoeging, 1);
    }

    @Test
    void TestgebruikersNaamInUse() {
        BeherenUsers beheer = new BeherenUsers();

        boolean gebruikersnaamInGebruik = beheer.gebruikersNaamInUse("Tarun123");
        assertTrue(gebruikersnaamInGebruik);

        boolean gebruikersnaamNietInGebruik = beheer.gebruikersNaamInUse("Testnaam123");
        assertFalse(gebruikersnaamNietInGebruik);

    }
}