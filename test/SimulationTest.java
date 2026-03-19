import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {


    @Test
    void setup(){
        Simulation sim = new Simulation();
        assertNull(sim.getHospital());
        sim.setup();
        assertNotNull(sim.getHospital());
    }

    @Test
    void randomDouble(){
        Simulation sim = new Simulation();
        sim.setup();
        double firstValue = Simulation.random();
        sim.setup();
        assertEquals(firstValue, Simulation.random(), "Simulation rng is not seeded properly");
    }

}