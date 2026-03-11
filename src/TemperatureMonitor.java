public class TemperatureMonitor extends Device{
    private double value;
    public Observation sample(){
        value = Math.random() * 8  + 34;
        return new Temperature(value);
    }
}
