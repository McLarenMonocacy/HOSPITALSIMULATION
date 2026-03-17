public class OxygenSaturation extends Observation{
    private double saturation;

    public OxygenSaturation(double satur){
        saturation = satur;
    }

    public boolean dangerous(){
        return saturation < 95;
    }

    public String data(){
        return "Oxygen Saturation: " + saturation + " SpO2";
    }
}
