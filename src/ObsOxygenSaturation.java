public class ObsOxygenSaturation extends Observation{
    private double saturation;

    public ObsOxygenSaturation(double saturation){
        this.saturation = saturation;
        super(3,false, 3);
    }

    public boolean dangerous(){
        return saturation < 95;
    }

    public String data(){
        return "Oxygen Saturation: " + saturation + " SpO2";
    }
}
