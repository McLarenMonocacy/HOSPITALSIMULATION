import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObsTemperatureTest {
    @Test
    void dangerousHigh(){
        Observation observation = new ObsTemperature(50);
        assertTrue(observation.dangerous(), "High temperature not considered dangerous");
    }

    @Test
    void notDangerous(){
        Observation observation = new ObsTemperature(35);
        assertFalse(observation.dangerous(), "In range temperature considered dangerous");
    }

    @Test
    void dangerousLow(){
        Observation observation = new ObsTemperature(20);
        assertTrue(observation.dangerous(), "Low temperature not considered dangerous");
    }

    @Test
    void priority(){
        Observation observation = new ObsTemperature(1);
        assertEquals(3, observation.getPriority(), "Priority not expected value");
    }
}
