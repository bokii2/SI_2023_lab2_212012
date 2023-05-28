import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private final SILab2 userT = new SILab2();

    @Test
    void exceptionTest(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> userT.function(null, null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }

    /*@Test
    void usernameTest(){
        User user = new User(null, "boki_softversko", "smth@smth.com");
        boolean ex = userT.function(user, null);
        assertTrue(ex);
    }*/
}