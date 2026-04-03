public class DivTemperatureMonitor extends Device{
    private double value = 36.5;
    
    public Observation sample(){
        double change = 3 - Simulation.random(6);
        value += change;
        return new ObsTemperature(value);
    }
}
