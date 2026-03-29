import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivTemperatureMonitorTest {

    @BeforeEach
    void preTest(){
        Simulation sim = new Simulation();
        sim.setup();
    }

    @Test
    void sample() {
        DivTemperatureMonitor device = new DivTemperatureMonitor();
        assertEquals(Observation.class, device.sample().getClass().getSuperclass(), "Sample didn't return an observation");
    }
}