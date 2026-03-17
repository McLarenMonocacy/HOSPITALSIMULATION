import java.util.Random;

public class HeartRateMonitor extends Device{
    private double value = 80;
    private Random random = new Random();
    
    public Observation sample(){
        double change = 10 - random.nextDouble(20);
        value += change;
        return new Temperature(value);
    }

    public Observation seededSample(Random rng){
        double change = 10 - rng.nextDouble(20);
        value += change;
        return new Temperature(value);
    }
}
