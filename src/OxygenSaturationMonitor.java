import java.util.Random;

public class OxygenSaturationMonitor extends Device{
    private double value = 97;
    
    public Observation sample(){
        double change = 2 - Simulation.random(4);
        value += change;
        return new Temperature(value);
    }
}

