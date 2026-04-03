import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObsHeartRateTest {
    @Test
    void dangerousHigh(){
        Observation observation = new ObsHeartRate(150);
        assertTrue(observation.dangerous(), "High heart rate not considered dangerous");
    }

    @Test
    void notDangerous(){
        Observation observation = new ObsHeartRate(65);
        assertFalse(observation.dangerous(), "In range heart rate considered dangerous");
    }

    @Test
    void dangerousLow(){
        Observation observation = new ObsHeartRate(20);
        assertTrue(observation.dangerous(), "Low heart rate not considered dangerous");
    }

    @Test
    void priority(){
        Observation observation = new ObsHeartRate(1);
        assertEquals(4, observation.getPriority(), "Priority not expected value");
    }

}