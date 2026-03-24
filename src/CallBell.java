public class CallBell extends Device{
    @Override
    public Observation sample() {
        return new CallBellCall(Simulation.random() > 0.95);
    }
}
