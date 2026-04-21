public class Main {
    private static Simulation sim;

    public static Simulation getSim() {
        return sim;
    }

    public static void setupSimForTests(){
        sim = new Simulation();
        sim.setup();
    }

    public static void main(String[] args) {
        sim = new Simulation();
        sim.setup();
        sim.run();
        sim.process();
    }
}