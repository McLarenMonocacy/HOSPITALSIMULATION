public class ObsBloodPressure extends Observation{

    private int systolic, diastolic;

    public ObsBloodPressure(int systolic, int diastolic){
        this.systolic = systolic;
        this.diastolic = diastolic;
        super(3,false, 2);
    }

    //Source: https://my.clevelandclinic.org/health/diagnostics/17649-blood-pressure
    @Override
    public boolean dangerous() {
        boolean output = false;
        if (systolic >= 180 || diastolic >= 120) output = true;
        if (systolic <= 90 || diastolic < 60) output = true;
        return output;
    }

    @Override
    public String data() {
        return "Blood pressure: " + systolic + "/" + diastolic + ".";
    }
}
