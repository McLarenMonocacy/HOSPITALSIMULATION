public class HeartRate extends Observation{
    private double bpm;
    
    public HeartRate(double beats){
        bpm = beats;
    }

    public boolean dangerous(){
        return bpm < 55 || bpm > 105;
    }

    public String data(){
        return "Heart rate: " + bpm + " bpm";
    }

}
