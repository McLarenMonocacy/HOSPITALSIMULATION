import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObsRespiratoryRateTest {
    @Test
    void dangerousHigh(){
        Observation observation = new ObsRespiratoryRate(50);
        assertTrue(observation.dangerous(), "High respiratory rate not considered dangerous");
    }

    @Test
    void notDangerous(){
        Observation observation = new ObsRespiratoryRate(15);
        assertFalse(observation.dangerous(), "In range respiratory rate considered dangerous");
    }

    @Test
    void dangerousLow(){
        Observation observation = new ObsRespiratoryRate(1);
        assertTrue(observation.dangerous(), "Low respiratory rate not considered dangerous");
    }

    @Test
    void priority(){
        Observation observation = new ObsRespiratoryRate(1);
        assertEquals(4, observation.getPriority(), "Priority not expected value");
    }

}