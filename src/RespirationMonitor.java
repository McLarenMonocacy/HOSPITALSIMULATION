   import java.util.Random;

public class RespirationMonitor extends Device{
    private int value = 16;
    private Random random = new Random();
    
    public Observation sample(){
        double change = 3 - random.nextDouble(6);
        value += change;
        return new Temperature(value);
    }

    public Observation seededSample(Random rng){
        double change = 3 - rng.nextDouble(6);
        value += change;
        return new RespiratoryRate(value);
    }
}

