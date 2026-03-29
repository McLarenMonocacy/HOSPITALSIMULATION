public class ObsTemperature extends Observation{
    private double celsiusValue;

    public ObsTemperature(double cVal){
        celsiusValue = cVal;
    }

    public boolean dangerous(){
        return celsiusValue <= 35 || celsiusValue >= 38;
    }

    public String data(){
        return "Temperature: " + celsiusValue + " C"; 
    }
}
