import com.example.carbonbattles.Ranglijst;
import com.example.carbonbattles.Models.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RanglijstTest {

    @Test
    void RanglijstGesorteerd() {

        Ranglijst rang = new Ranglijst();
        //Test medewerkers aanmaken
        Medewerker medewerker1 = new Medewerker("Tarun", "gebruikerTarun", "123");
        Medewerker medewerker2 = new Medewerker("Konrad", "gebruikerKonrad", "123");
        Medewerker medewerker3 = new Medewerker("Pieter", "gebruikerPieter", "123");

        //Medewerkers punten geven
        medewerker1.createARit(40, new Fiets(), false, "01-01-2022" );
        medewerker2.createARit(10, new Fiets(), false, "01-01-2021" );
        medewerker3.createARit(45, new Fiets(), false, "01-01-2020" );

        //Medewerkers zitten in een lijst van Users
        ArrayList<User> TestLijst = new ArrayList<>();
        TestLijst.add(medewerker1);
        TestLijst.add(medewerker2);
        TestLijst.add(medewerker3);
        ArrayList<User> gesorteerdeLijst = rang.toonRanglijstMedewerkers(TestLijst);

        //hier wordt gecheckt of het sorteren is gelukt aan de hand van het aantal punten van hoog naar laag.
        for (int i = 0; i < gesorteerdeLijst.size() - 1; i++) {
            assertTrue(gesorteerdeLijst.get(i).getAantalPunten() > gesorteerdeLijst.get(i+1).getAantalPunten());
        }

        //visualisatie
        for (User print : gesorteerdeLijst) {
            System.out.println(print.getNaam() + " " + print.getAantalPunten());
        }
    }
}
