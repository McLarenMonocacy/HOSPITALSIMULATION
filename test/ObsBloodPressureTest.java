import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObsBloodPressureTest {
    @Test
    void dangerousHigh(){
        Observation observation = new ObsBloodPressure(190,130);
        assertTrue(observation.dangerous(), "High blood pressure not considered dangerous");
        observation = new ObsBloodPressure(190,80);
        assertTrue(observation.dangerous(), "High blood pressure (only systolic) not considered dangerous");
        observation = new ObsBloodPressure(120,130);
        assertTrue(observation.dangerous(), "High blood pressure (only diastolic) not considered dangerous");
    }

    @Test
    void notDangerous(){
        Observation observation = new ObsBloodPressure(120,80);
        assertFalse(observation.dangerous(), "In range heart rate considered dangerous");
    }

    @Test
    void dangerousLow(){
        Observation observation = new ObsBloodPressure(70,50);
        assertTrue(observation.dangerous(), "Low blood pressure not considered dangerous");
        observation = new ObsBloodPressure(70,80);
        assertTrue(observation.dangerous(), "Low blood pressure (only systolic) not considered dangerous");
        observation = new ObsBloodPressure(120,50);
        assertTrue(observation.dangerous(), "Low blood pressure (only diastolic) not considered dangerous");
    }

    @Test
    void priority(){
        Observation observation = new ObsBloodPressure(1,1);
        assertEquals(3, observation.getPriority(), "Priority not expected value");
    }

}