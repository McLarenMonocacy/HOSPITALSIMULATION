public class ObsOxygenSaturation extends Observation{
    private double saturation;

    public ObsOxygenSaturation(double satur){
        saturation = satur;
        priority = 3;
    }

    public boolean dangerous(){
        return saturation < 95;
    }

    public String data(){
        return "Oxygen Saturation: " + saturation + " SpO2";
    }
}
