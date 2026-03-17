import java.util.Random;

public class OxygenSaturationMonitor extends Device{
    private double value = 97;
    private Random random = new Random();
    
    public Observation sample(){
        double change = 2 - random.nextDouble(4);
        value += change;
        return new Temperature(value);
    }

    public Observation seededSample(Random rng){
        double change = 2 - rng.nextDouble(4);
        value += change;
        return new OxygenSaturation(value);
    }
}

