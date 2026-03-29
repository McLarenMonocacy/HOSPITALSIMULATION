import org.junit.jupiter.api.Test;

import java.util.Random;

public class DivTemperatureMonitorTest {
    @Test
    void consistentNum(){
        DivTemperatureMonitor monitor = new DivTemperatureMonitor();
        Random rand = new Random(12345);
        assertEquals(37.32918135703717, monitor.seededSample(rand));
    }
}
