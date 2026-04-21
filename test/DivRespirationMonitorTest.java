import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivRespirationMonitorTest {

    @BeforeEach
    void preTest(){
        Simulation sim = new Simulation();
        sim.setup();
    }

    @Test
    void sample() {
        DivRespirationMonitor device = new DivRespirationMonitor();
        assertEquals(Observation.class, device.sample().getClass().getSuperclass(), "Sample didn't return an observation");
    }

}