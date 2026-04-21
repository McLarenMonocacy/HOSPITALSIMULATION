public class ObsHeartRate extends Observation{
    private double bpm;
    
    public ObsHeartRate(double beats){
        bpm = beats;
        super(4,false,3);
    }

    //Source:https://www.healthline.com/health/dangerous-heart-rate#diagnosing-the-cause
    public boolean dangerous(){
        return bpm < 60 || bpm > 100;
    }

    public String data(){
        return "Heart rate: " + bpm + " bpm";
    }

}
