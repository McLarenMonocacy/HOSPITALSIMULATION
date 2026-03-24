public class CallBellCall extends Observation{ //Rename this class

    Boolean called;

    public CallBellCall(Boolean called){
        this.called = called;
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
