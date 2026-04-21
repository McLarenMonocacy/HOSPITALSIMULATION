import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Simulation {

    private boolean hasSimulationRun = false;
    private boolean hasSetupRun = false;
    private static Random random;

    private Hospital hospital;
    private Double runTime, currentTime;

    private CacyLinkedList<Alert> resolvedAlerts;

    public Simulation(){
    }

    public void setup(){
        setup(5L, 100, false);
    }
    public void setup(Long rngSeed, double runTime, boolean isForTests){
        random = new Random(rngSeed);
        hospital = new Hospital();
        this.runTime = runTime;
        currentTime = 0d;

        resolvedAlerts = new CacyLinkedList<>();

        if (!isForTests){
            for (int i = 0; i < 10; i++) {
                hospital.addPatient(Patient.create());
                hospital.addNurse(new Nurse(Simulation.randomInt(10)));
            }
        }

        hasSetupRun = true;
    }

    public void run(){
        if (!hasSetupRun) return;

        while (currentTime < runTime){
            hospital.pollDevices();
            hospital.runNurses();
            currentTime++; //Temp time advance until a proper solution
        }

        hasSimulationRun = true;
        hasSetupRun = false; //Prevents running again without resetting via setup
    }

    public void process(){
        if (!hasSimulationRun) return; //Can't process what hasn't happened
        try {

            FileWriter writer = new FileWriter("output.txt");
            resolvedAlerts.initIterator();
            while (resolvedAlerts.hasNext()){
                Alert alert = resolvedAlerts.next();
                writer.append(alert.getStartTime() + "," + alert.getEndTime() + "," + alert.getDifficulty() + "," + alert.getDuration() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addResolvedAlert(Alert alert){
        resolvedAlerts.add(alert);
    }

    public Hospital getHospital() {
        return hospital;
    }
    public double getCurrentTime(){
        return currentTime;
    }

    public static double randomDouble(){
        return random.nextDouble();
    }
    public static double randomDouble(double bounds){
        return random.nextDouble(bounds);
    }
    public static int randomInt(int minValue, int maxValue){
        return random.nextInt(minValue, maxValue + 1);
    }
    public static int randomInt(int maxValue){
        return random.nextInt(maxValue+1);
    }


}
