import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivOxygenSaturationMonitorTest {

    @BeforeEach
    void preTest(){
        Simulation sim = new Simulation();
        sim.setup();
    }

    @Test
    void sample() {
        DivOxygenSaturationMonitor device = new DivOxygenSaturationMonitor();
        assertEquals(Observation.class, device.sample().getClass().getSuperclass(), "Sample didn't return an observation");
    }

}