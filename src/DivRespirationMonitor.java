public class DivRespirationMonitor extends Device{
    private int value = 16;
    
    public Observation sample(){
        double change = 3 - Simulation.randomDouble(6);
        value += change;
        return new ObsRespiratoryRate(value);
    }
}

