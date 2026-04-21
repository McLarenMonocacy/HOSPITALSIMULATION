import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NurseTest {

    @Test
    void getSkillLevel() {
        assertEquals(2d,new Nurse(2).getSkillLevel());
    }
    @Test
    void UUID(){
        Nurse nurse1 = new Nurse(1);
        Nurse nurse2 = new Nurse(1);
        assertNotNull(nurse1.getID(), "UUID is null");
        assertNotEquals(nurse1.getID(),nurse2.getID(), "UUID are the same");
    }
}