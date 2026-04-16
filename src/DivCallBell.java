public class DivCallBell extends Device{
    @Override
    public Observation sample() {
        return new ObsCallBell(Simulation.randomDouble() > 0.95);
    }
}
