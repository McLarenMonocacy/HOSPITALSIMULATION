import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObsOxygenSaturationTest {
    @Test
    void notDangerous(){
        Observation observation = new ObsOxygenSaturation(100);
        assertFalse(observation.dangerous(), "In range oxygen saturation considered dangerous");
    }

    @Test
    void dangerousLow(){
        Observation observation = new ObsOxygenSaturation(50);
        assertTrue(observation.dangerous(), "Low oxygen saturation not considered dangerous");
    }

    @Test
    void priority(){
        Observation observation = new ObsOxygenSaturation(1);
        assertEquals(3, observation.getPriority(), "Priority not expected value");
    }

}