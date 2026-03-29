public class ObsHeartRate extends Observation{
    private double bpm;
    
    public ObsHeartRate(double beats){
        bpm = beats;
        priority = 4;
    }

    public boolean dangerous(){
        return bpm < 55 || bpm > 105;
    }

    public String data(){
        return "Heart rate: " + bpm + " bpm";
    }

}
