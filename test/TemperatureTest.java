import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureTest {
    @Test
    void dangerousHigh(){
        Temperature temp = new Temperature(50);
        assertTrue(temp.dangerous());
    }

    @Test
    void dangerousLow(){
        Temperature temp = new Temperature(20);
        assertTrue(temp.dangerous());
    }
}
