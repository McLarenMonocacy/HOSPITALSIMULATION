public class DivBloodPressure extends Device{
    int systolic, diastolic;
    @Override
    public Observation sample() {
        int change = 10 - Simulation.randomInt(20);
        systolic += change;
        change = 10 - Simulation.randomInt(20);
        diastolic += change;
        return new ObsBloodPressure(systolic,diastolic);
    }
}
