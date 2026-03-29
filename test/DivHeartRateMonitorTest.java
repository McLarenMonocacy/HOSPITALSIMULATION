import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivHeartRateMonitorTest {

    @BeforeEach
    void preTest(){
        Simulation sim = new Simulation();
        sim.setup();
    }

    @Test
    void sample() {
        DivHeartRateMonitor device = new DivHeartRateMonitor();
        assertEquals(Observation.class, device.sample().getClass().getSuperclass(), "Sample didn't return an observation");
    }

}