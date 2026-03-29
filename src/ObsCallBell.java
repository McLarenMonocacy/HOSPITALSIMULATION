public class ObsCallBell extends Observation{ //Rename this class

    Boolean called;

    public ObsCallBell(Boolean called){
        this.called = called;
        priority = 1;
    }

    @Override
    public boolean dangerous() {
        return called;
    }

    @Override
    public String data() {
        return "Bell was called = " + called;
    }
}
