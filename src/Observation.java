public abstract class Observation{
    int priority; //Priority if an alert is generated
    abstract public boolean dangerous();
    abstract public String data();

    public int getPriority() {
        return priority;
    }
}