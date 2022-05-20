import com.example.carbonbattles.Dashboard;
import com.example.carbonbattles.Fiets;
import com.example.carbonbattles.Medewerker;
import com.example.carbonbattles.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DashboardTest{

    @Test
    void SorterenRanglijstTop5() {
        Dashboard dash = new Dashboard();

        //Test medewerkers aanmaken
        Medewerker medewerker1 = new Medewerker("Tarun", "gebruikerTarun", "123");
        Medewerker medewerker2 = new Medewerker("Konrad", "gebruikerKonrad", "123");
        Medewerker medewerker3 = new Medewerker("Pieter", "gebruikerPieter", "123");
        Medewerker medewerker4 = new Medewerker("Adam", "gebruikerAdam", "123");
        Medewerker medewerker5 = new Medewerker("Jip", "gebruikerJip", "123");
        Medewerker medewerker6 = new Medewerker("Romano", "gebruikerRomano", "123");
        Medewerker medewerker7 = new Medewerker("Karel", "gebruikerKarel", "123");
        Medewerker medewerker8 = new Medewerker("Anonymous", "gebruikerAnon", "123");

        //Medewerkers punten geven
        medewerker1.createARit(40, new Fiets(), false, "01-01-2022" );
        medewerker2.createARit(10, new Fiets(), false, "01-01-2021" );
        medewerker3.createARit(45, new Fiets(), false, "01-01-2020" );
        medewerker4.createARit(20, new Fiets(), false, "01-01-2020" );
        medewerker5.createARit(25, new Fiets(), false, "01-01-2020" );
        medewerker6.createARit(30, new Fiets(), false, "01-01-2020" );
        medewerker7.createARit(5,  new Fiets(), false, "01-01-2020" );
        medewerker8.createARit(27, new Fiets(), false, "01-01-2020" );

        //Medewerkers zitten in een lijst van Users
        ArrayList<User> TestLijst = new ArrayList<>();
        TestLijst.add(medewerker1);
        TestLijst.add(medewerker2);
        TestLijst.add(medewerker3);
        TestLijst.add(medewerker4);
        TestLijst.add(medewerker5);
        TestLijst.add(medewerker6);
        TestLijst.add(medewerker7);
        TestLijst.add(medewerker8);

        ArrayList<User> gesorteerdeLijst = dash.toonRanglijstManager(TestLijst);

        //hier wordt gecheckt of het sorteren is gelukt aan de hand van het aantal punten van hoog naar laag.
        for (int i = 0; i < gesorteerdeLijst.size() - 1; i++) {
            assertTrue(gesorteerdeLijst.get(i).getAantalPunten() > gesorteerdeLijst.get(i+1).getAantalPunten());
        }
        //hier wordt gecheckt of alleen de top 5 wordt getoond
        assertEquals(5, gesorteerdeLijst.size());
        //visualisatie
        for (User print : gesorteerdeLijst) {
            System.out.println(print.getNaam() + " " + print.getAantalPunten());
        }
    }
}