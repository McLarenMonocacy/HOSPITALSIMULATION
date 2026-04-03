import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObsCallBellTest {

    @Test
    void dangerous(){
        Observation observation = new ObsCallBell(true);
        assertTrue(observation.dangerous(), "Called call bell not considered dangerous");
    }

    @Test
    void notDangerous(){
        Observation observation = new ObsCallBell(false);
        assertFalse(observation.dangerous(), "Uncalled call bell considered dangerous");
    }

    @Test
    void priority(){
        Observation observation = new ObsCallBell(true);
        assertEquals(1, observation.getPriority(), "Priority not expected value");
    }

}