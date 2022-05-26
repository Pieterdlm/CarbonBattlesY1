import com.example.carbonbattles.Models.Fiets;
import com.example.carbonbattles.Models.Medewerker;
import com.example.carbonbattles.Models.User;
import com.example.carbonbattles.inzichtPortaal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class inzichtPortaalTest {

    @Test
    void LijstGesorteerdVanAtotZ() {

        inzichtPortaal inzicht = new inzichtPortaal();
        //Test medewerkers aanmaken
        Medewerker medewerker1 = new Medewerker("Tarun", "gebruikerTarun", "123");
        Medewerker medewerker2 = new Medewerker("Konrad", "gebruikerKonrad", "123");
        Medewerker medewerker3 = new Medewerker("Pieter", "gebruikerPieter", "123");


        //Medewerkers zitten in een lijst van Users
        ArrayList<User> TestLijst = new ArrayList<>();
        TestLijst.add(medewerker1);
        TestLijst.add(medewerker2);
        TestLijst.add(medewerker3);
        ArrayList<User> gesorteerdeLijst = inzicht.lijstMedewerkersA_tot_Z(TestLijst);
        //maken een lijst met wat we verwachten
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Konrad", "Pieter", "Tarun"));

        //hier wordt gecheckt of het sorteren is gelukt aan de hand van alphabetische volgorde.
        for (int i = 0; i < gesorteerdeLijst.size() - 1; i++) {
            assertEquals( expected.get(i), gesorteerdeLijst.get(i).getNaam());
        }

        //visualisatie
        for (User print : gesorteerdeLijst) {
            System.out.println(print.getNaam());
        }
    }

}