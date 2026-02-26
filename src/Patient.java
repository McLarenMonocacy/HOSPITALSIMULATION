import java.util.Date;
import java.util.UUID;

public class Patient {
    private UUID uuid;
    private String name;
    private Date dateOfBirth;

    public Patient(){

    }

    private static UUID generateUUID(){
        return UUID.randomUUID();
    }
}
