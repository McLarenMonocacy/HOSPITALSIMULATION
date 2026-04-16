import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NurseTest {

    @Test
    void getSkillLevel() {
        assertEquals(2d,new Nurse(2).getSkillLevel());
    }
}