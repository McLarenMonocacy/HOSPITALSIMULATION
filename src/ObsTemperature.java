public class ObsTemperature extends Observation{
    private double celsiusValue;

    public ObsTemperature(double cVal){
        celsiusValue = cVal;

        if (celsiusValue >= 40.6) priority = 4;
        else priority = 3;
    }

    //Source: https:https://www.hopkinsmedicine.org/health/conditions-and-diseases/vital-signs-body-temperature-pulse-rate-respiration-rate-blood-pressure
    public boolean dangerous(){
        return celsiusValue < 35 || celsiusValue >= 37.7778;
    }

    public String data(){
        return "Temperature: " + celsiusValue + " C"; 
    }
}
