public class Alert{
    private double startTime;
    private double endTime;
    private Observation data;
    private boolean urgent;

    public Alert(double start, Observation obs){
        startTime = start;
        data = obs;
        if (obs.veryDangerous()){
            urgent = true;
        }
        else urgent = false;
    }

    public toString(){
        return "Start Time: " + startTime + " End Time: " + endTime + " Urgent: " + urgent; 
    }
}