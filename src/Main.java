//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Simulation sim;

    public Simulation getSim() {
        return sim;
    }

    public static void main(String[] args) {
        sim = new Simulation();
        sim.run();
        sim.process();
    }
}