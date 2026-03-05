public class Simulation {
    private boolean hasSimulationRun = false;
    public Simulation(){
        setup();
    }

    private void setup(){
    }

    public void run(){
    }

    public void process(){
        if (!hasSimulationRun) return; //Can't process what hasn't happened
    }

    public static double random(){
        //NOTE: needs setup to accept a seed on setup
        return Math.random();
    }
}
