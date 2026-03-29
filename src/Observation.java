public class Observation {
    int priority; //Priority if it was dangerous/needed to be attended

    public Observation(){
        priority = Simulation.randomInt(1,5);
    }

    public boolean veryDangerous() {
        return Simulation.random() < 0.1d;
    }

    public int getPriority() {
        return priority;
    }
}
