import java.util.UUID;

public class Nurse {

    private final UUID ID;
    private final double skillLevel;

    public Nurse (double skillLevel){
        this.skillLevel = skillLevel;
        this.ID = UUID.randomUUID();
    }

    public double getSkillLevel() {
        return skillLevel;
    }
    public UUID getID() {
        return ID;
    }
}
