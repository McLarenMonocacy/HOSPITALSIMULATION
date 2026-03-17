public class RespiratoryRate extends Observation{
    private int bpm;

    public RespiratoryRate(int breaths){
        bpm = breaths;
    }
    
    public boolean dangerous(){
        return bpm < 12 || bpm > 20;
    }

    public String data(){
        return "Breaths per minute: " + bpm;
    }
}
