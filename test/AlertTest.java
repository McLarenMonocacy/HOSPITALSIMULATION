import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlertTest {

    @BeforeEach
    void preTest(){
        Main.setupSimForTests();
    }

    @Test
    void attemptResolve(){
        Alert alert = new Alert(-1, new ObsTest(false));
        assertFalse(alert.attemptResolve());
        alert.assignNurse(new Nurse(999));
        assertTrue(alert.attemptResolve(), "Highly skilled nurse didn't resolve alert");
        alert =  new Alert(-1, new ObsTest(false));
        alert.assignNurse(new Nurse(-999));
        assertFalse(alert.attemptResolve(), "Negatively skilled nurse resolved alert");
        alert = new Alert(1, new ObsTest(true));
        alert.assignNurse(new Nurse(1));
        assertFalse(alert.attemptResolve(), "Routine alert resolved without time passing");
        alert = new Alert(-100, new ObsTest(true));
        alert.assignNurse(new Nurse(1));
        assertTrue(alert.attemptResolve(), "Routine alert not resolved after time has passes");

    }


    @Test
    void resolved() {
        Alert alert = new Alert(-1, new ObsTest(1,false, 1));
        alert.assignNurse(new Nurse(20));
        alert.attemptResolve();
        assertEquals(-1,alert.getStartTime(), "Start time not stored properly");
        assertEquals(0,alert.getEndTime(), "End time not stored properly");
    }

    @Test
    void assignNurse(){
        Alert alert = new Alert(1, new ObsTest(1,false, 1));
        assertEquals(0,alert.getNumbNurses());
        alert.assignNurse(new Nurse(20));
        assertEquals(1,alert.getNumbNurses());
        alert.assignNurse(new Nurse(20));
        assertEquals(2,alert.getNumbNurses());
        alert.attemptResolve();
        assertEquals(0, alert.getNumbNurses());
    }
}