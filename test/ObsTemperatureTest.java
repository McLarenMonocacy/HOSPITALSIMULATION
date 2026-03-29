import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObsTemperatureTest {
    @Test
    void dangerousHigh(){
        ObsTemperature temp = new ObsTemperature(50);
        assertTrue(temp.dangerous());
    }

    @Test
    void dangerousLow(){
        ObsTemperature temp = new ObsTemperature(20);
        assertTrue(temp.dangerous());
    }
}
