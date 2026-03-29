public class ObsRespiratoryRate extends Observation{
    private int bpm;

    public ObsRespiratoryRate(int breaths){
        bpm = breaths;
    }
    
    public boolean dangerous(){
        return bpm < 12 || bpm > 20;
    }

    public String data(){
        return "Breaths per minute: " + bpm;
    }
}
