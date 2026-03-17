import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

public class TemperatureMonitorTest {
    @Test
    void consistentNum(){
        TemperatureMonitor monitor = new TemperatureMonitor();
        Random rand = new Random(12345);
        assertEquals(37.32918135703717, monitor.seededSample(rand));
    }
}
