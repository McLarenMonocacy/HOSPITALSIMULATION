public class ObsTest extends Observation{
    //Used for alert Tests
    public ObsTest(int priority, boolean isRoutine, double durationOrDifficulty) {
        super(priority, isRoutine, durationOrDifficulty);
    }

    public ObsTest(boolean isRoutine){
        super(1,isRoutine, 5);
    }
    @Override
    public boolean dangerous() {
        return true;
    }

    @Override
    public String data() {
        return "TEST OBSERVATION";
    }
}
