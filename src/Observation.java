public abstract class Observation{
    private final int priority; //Priority if an alert is generated
    private final boolean isRoutine; //If the resolution should be time based or skill check based
    private double duration; //Time to resolve the alert
    private double difficulty; //Difficulty multiplier for the skill checks
    abstract public boolean dangerous();
    abstract public String data();

    public Observation(int priority, boolean isRoutine, double durationOrDifficulty){
        this.priority = priority;
        this.isRoutine = isRoutine;
        if (isRoutine) this.duration = durationOrDifficulty;
        else this.difficulty = Math.clamp(durationOrDifficulty,0,5);
    }

    public int getPriority() {
        return priority;
    }
    public boolean isRoutine() {
        return isRoutine;
    }
    public double getDuration() {
        return duration;
    }
    public double getDifficulty() {
        return difficulty;
    }
}