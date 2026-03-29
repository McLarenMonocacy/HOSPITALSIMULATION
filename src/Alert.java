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
        //Should we check if the resolved time is after the start time (i.e. prevent the end time from being before the start time)?
        if (resolved) return;
        endTime = time;
        resolved = true;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public String toString(){
        return "Start Time: " + startTime + " End Time: " + endTime + " Priority: " + priority;
    }
}