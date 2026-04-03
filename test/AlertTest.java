import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlertTest {

    @BeforeEach
    void preTest(){
        Simulation simulation = new Simulation();
        simulation.setup();
    }

    @Test
    void resolve() {
        Alert alert = new Alert(4, new DivTemperatureMonitor().sample());
        alert.resolve(5);
        assertEquals(4,alert.getStartTime(), "Start time not stored properly");
        assertEquals(5,alert.getEndTime(), "End time not stored properly");
        alert.resolve(84384);
        assertEquals(5,alert.getEndTime(), "End time was overridden");
    }
}