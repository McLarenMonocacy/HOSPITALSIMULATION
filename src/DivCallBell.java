public class DivCallBell extends Device{
    @Override
    public Observation sample() {
        return new ObsCallBell(Simulation.random() > 0.95);
    }
}
