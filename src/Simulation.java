import java.util.Random;

public class Simulation {

    private boolean hasSimulationRun = false;
    private boolean hasSetupRun = false;
    private static Random random;

    private Hospital hospital;
    private Double runTime, currentTime;

    public Simulation(){
    }

    public void setup(){
        setup(5L, 100);
    }
    public void setup(Long rngSeed, double runTime){
        random = new Random(rngSeed);
        hospital = new Hospital();
        this.runTime = runTime;
        currentTime = 0d;

        hasSetupRun = true;
    }

    public void run(){
        if (!hasSetupRun) return;

        while (currentTime < runTime){
            //Simulate here
        }

        hasSimulationRun = true;
        hasSetupRun = false; //Prevents running again without resetting via setup
    }

    public void process(){
        if (!hasSimulationRun) return; //Can't process what hasn't happened
    }


    public Hospital getHospital() {
        return hospital;
    }

    public static double random(){
        return random.nextDouble();
    }
    public static double random(double bounds){
        return random.nextDouble(bounds);
    }
    public static int randomInt(int minValue, int maxValue){
        return random.nextInt(minValue, maxValue + 1);
    }
}
