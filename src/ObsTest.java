public class ObsTest extends Observation{
    public ObsTest(int priority, boolean isRoutine, double durationOrDifficulty) {
        super(priority, isRoutine, durationOrDifficulty);
    }

    @Override
    public boolean dangerous() {
        return false;
    }

    @Override
    public String data() {
        return "TEST OBSERVATION";
    }
}
