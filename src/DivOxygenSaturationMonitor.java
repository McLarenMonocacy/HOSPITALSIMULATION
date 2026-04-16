public class DivOxygenSaturationMonitor extends Device{
    private double value = 97;
    
    public Observation sample(){
        double change = 2 - Simulation.randomDouble(4);
        value += change;
        return new ObsOxygenSaturation(value);
    }
}

