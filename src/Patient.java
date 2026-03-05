import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class Patient {
    private final UUID uuid;
    private String name;
    private Date dateOfBirth;

    public Patient(){
        uuid = generateUUID();
    }

    private static UUID generateUUID(){
        return UUID.randomUUID();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setName(String name) {
        //Note: stores the name in all lowercase to ignore case
        this.name = name.toLowerCase(Locale.US);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
