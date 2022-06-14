import com.example.carbonbattles.CarbonBattles;
import com.example.carbonbattles.Models.User;
import com.example.carbonbattles.WaarschuwingDeleteUser;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class WaarschuwingDeleteUserTest {

    ArrayList<User> lijstMetUsers = CarbonBattles.getUsers();





//test of een medewerker uit de lijst is verwijderd door de size van de arraylist voor de verwijdering wordt vergeleken met de size na de verwijdering
    @Test
    public void testDelete(){

        int lijstMetusersBeforeDelete = lijstMetUsers.size();
        System.out.println(lijstMetUsers.size());
        WaarschuwingDeleteUser.delete(lijstMetUsers.get(2));
        int lijstMetUsersAfterDelete =  lijstMetUsers.size();
        System.out.println(lijstMetUsers.size());
        Assert.assertEquals(lijstMetusersBeforeDelete - lijstMetUsersAfterDelete,1);
    }
}

