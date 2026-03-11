public class Temperature extends Observation{
    private double celsiusValue;

    public Temperature (double cVal){
        celsiusValue = cVal;
    }

    public boolean dangerous(){
        return celsiusValue <= 35 || celsiusValue >= 38;
    }

    public String data(){
        return "Temperature: " + celsiusValue + " C"; 
    }
}
