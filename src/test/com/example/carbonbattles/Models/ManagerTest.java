package com.example.carbonbattles.Models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void alleenMedewerkers() {
        Manager manager = new Manager("test", "test", "test");
        ArrayList<User> alleenMedewerkers = manager.alleenMedewerkers();
        int teller = 0;
        for (User user : alleenMedewerkers){
            if (user.isAdmin()){
                teller++;
            }
        }
        assertEquals(0, teller);
    }
}