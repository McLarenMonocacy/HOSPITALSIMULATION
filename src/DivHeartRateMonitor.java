public class DivHeartRateMonitor extends Device{
    private double value = 80;
    
    public Observation sample(){
        double change = 10 - Simulation.random(20);
        value += change;
        return new ObsHeartRate(value);
    }
}
