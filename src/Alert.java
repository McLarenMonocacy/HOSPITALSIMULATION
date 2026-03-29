public class Alert{
    private final double startTime;
    private double endTime;
    private boolean resolved = false;

    private final Observation data;
    private final int priority;

    public Alert(double start, Observation obs){
        startTime = start;
        data = obs;
        priority = obs.getPriority();
    }

    public void resolve(double time){
        if (resolved) return;
        endTime = time;
    }

    public String toString(){
        return "Start Time: " + startTime + " End Time: " + endTime + " Priority: " + priority;
    }
}