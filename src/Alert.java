public class Alert{
    private final double startTime;
    private double endTime;
    private boolean resolved = false;
    private final boolean isRoutine;
    private double duration;
    private double difficulty;

    private final Observation data;
    private final int priority;

    private final CacyLinkedList<Nurse> assignedNurses;

    public Alert(double start, Observation obs){
        startTime = start;
        data = obs;
        priority = obs.getPriority();
        isRoutine = obs.isRoutine();
        if (isRoutine) duration = obs.getDuration();
        else difficulty = obs.getDifficulty();
        assignedNurses = new CacyLinkedList<>();
    }

    public void assignNurse(Nurse nurse){
        assignedNurses.add(nurse);
    }

    public boolean attemptResolve (){
        if (assignedNurses.length() < 1) return false; //No nurses to resolve the alert
        if (isRoutine){
            if (Main.getSim().getCurrentTime() - startTime > duration) resolved();
        } else {
            assignedNurses.initIterator();
            while (assignedNurses.hasNext()){
                if (nurseTryResolveAlert(assignedNurses.next().getSkillLevel())){
                    break;
                }
            }
        }
        return resolved;
    }

    private void resolved(){
        //Should we check if the resolved time is after the start time (i.e. prevent the end time from being before the start time)?
        if (resolved) return;
        endTime = Main.getSim().getCurrentTime();
        resolved = true;
        while (assignedNurses.length() > 0){
            Main.getSim().getHospital().addNurse(assignedNurses.removeFirst());
        }
    }
    private boolean nurseTryResolveAlert(double skillLevel){
        boolean output = false;
        double calcDifficulty = (difficulty * 3.5) + 1; //Ranges from 4.5 to 18.5
        double skillCheck = Simulation.randomDouble(20) + skillLevel;
        if (calcDifficulty < skillCheck){
            resolved();
            output = true;
        }
        return output;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public int getPriority() {
        return priority;
    }

    public int getNumbNurses(){
        return assignedNurses.length();
    }
    public boolean getResolved(){
        return resolved;
    }
    public double getDifficulty() {
        return difficulty;
    }
    public double getDuration() {
        return duration;
    }
    public boolean isRoutine(){
        return isRoutine;
    }

    public String toString(){
        return "Start Time: " + startTime + " End Time: " + endTime + " Priority: " + priority;
    }
}