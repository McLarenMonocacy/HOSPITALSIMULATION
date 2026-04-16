public class Alert{
    private final double startTime;
    private double endTime;
    private boolean resolved = false;

    private final Observation data;
    private final int priority;

    private final CacyLinkedList<Nurse> assignedNurses;

    public Alert(double start, Observation obs){
        startTime = start;
        data = obs;
        priority = obs.getPriority();
        assignedNurses = new CacyLinkedList<>();
    }

    public void assignNurse(Nurse nurse){
        assignedNurses.add(nurse);
    }

    public void attemptResolve (){
        assignedNurses.initIterator();
        while (assignedNurses.hasNext()){
            if (nurseTryResolveAlert(assignedNurses.next().getSkillLevel())){
                break;
            }
        }
    }

    private void resolved(double time){
        //Should we check if the resolved time is after the start time (i.e. prevent the end time from being before the start time)?
        if (resolved) return;
        endTime = time;
        resolved = true;
        while (assignedNurses.length() > 0){
            Main.getSim().getHospital().addNurse(assignedNurses.removeFirst());
        }
    }
    private boolean nurseTryResolveAlert(double skillLevel){
        boolean output = false;
        double difficulty = (priority * 3.5) + 1; //Ranges from 4.5 to 18.5
        double skillCheck = Simulation.randomDouble(20) + skillLevel;
        if (difficulty < skillCheck){
            resolved(Main.getSim().getCurrentTime());
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

    public String toString(){
        return "Start Time: " + startTime + " End Time: " + endTime + " Priority: " + priority;
    }
}