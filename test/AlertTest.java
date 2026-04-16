import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlertTest {

    @BeforeEach
    void preTest(){
        Main.setupSimForTests();
    }

    @Test
    void resolved() {
        Alert alert = new Alert(-1, new ObsTemperature(1));
        alert.assignNurse(new Nurse(20));
        alert.attemptResolve();
        assertEquals(-1,alert.getStartTime(), "Start time not stored properly");
        assertEquals(0,alert.getEndTime(), "End time not stored properly");
    }

    @Test
    void assignNurse(){
        Alert alert = new Alert(1, new ObsTemperature(1));
        assertEquals(0,alert.getNumbNurses());
        alert.assignNurse(new Nurse(20));
        assertEquals(1,alert.getNumbNurses());
        alert.assignNurse(new Nurse(20));
        assertEquals(2,alert.getNumbNurses());
        alert.attemptResolve();
        assertEquals(0, alert.getNumbNurses());
    }
}