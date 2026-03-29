public class DivRespirationMonitor extends Device{
    private int value = 16;
    
    public Observation sample(){
        double change = 3 - Simulation.random(6);
        value += change;
        return new ObsTemperature(value);
    }
}

