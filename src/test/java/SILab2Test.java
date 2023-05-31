import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    //Every Branch Tests
    @Test
    void exceptionTest(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }

    @Test
    void usernameTest(){
        Assertions.assertEquals(true, SILab2.function(new User(null, "boki_softversko", "boki2@smth.com"), Collections.emptyList()));
    }

    @Test
    void UsersTests() {
        User u1 = new User("boki", "boki_softversko", "boki@smth.com");
        List<User> users = new ArrayList<>();
        users.add(u1);

        Assertions.assertEquals(false, SILab2.function(new User("boki", "boki", "bokac@smth.com"), users));
    }

    @Test
    void spaceTest(){
        Assertions.assertEquals(false, SILab2.function(new User("boki", "boki finki", "bokac@smthcom"), Collections.emptyList()));
    }

    @Test
    void specialCharacterTest(){
        Assertions.assertEquals(false, SILab2.function(new User("boki", "bokisoftversko", "boki@smthcom"), Collections.emptyList()));
    }

    //Multiple Condition Tests
    @Test
    void multipleConditionTest(){
        RuntimeException ex;
        //TXX
        ex=Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        Assertions.assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FTX
        ex=Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(new User("boki", null, "boki@smth.com"), null));
        Assertions.assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FFT
        ex=Assertions.assertThrows(RuntimeException.class, () -> SILab2.function(new User("boki", "boki_softversko", null), null));
        Assertions.assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //FFF
        Assertions.assertEquals(false, SILab2.function(new User("boki", "boki_softversko", "boki@smth.com"), Collections.emptyList()));
    }
}