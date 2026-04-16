public class ObsRespiratoryRate extends Observation{
    private int bpm;

    public ObsRespiratoryRate(int breaths){
        bpm = breaths;
        super (4,false,4);
    }

    //Source:https://www.lung.org/blog/respiratory-rate-vital-signs
    public boolean dangerous(){
        return bpm < 12 || bpm > 25;
    }

    public String data(){
        return "Breaths per minute: " + bpm;
    }
}
