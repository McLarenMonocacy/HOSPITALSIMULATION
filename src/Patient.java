import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class Patient {
    private final UUID uuid;
    private String name;
    private Date dateOfBirth;

    private final CacyLinkedList<Device> deviceList;

    public Patient(){
        uuid = generateUUID();
        deviceList = new CacyLinkedList<>();
        //Default values for name & DoB
        name = "John Doe";
        dateOfBirth = new Date(0L);
    }

    public CacyQueue<Alert> pollDevices(){
        CacyQueue<Alert> output = new CacyLinkedList<>();
        deviceList.initIterator();
        while (deviceList.hasNext()){
            Observation observation = deviceList.next().sample();
            if (observation.dangerous()){
                output.offer(new Alert(Main.getSim().getCurrentTime(), observation));
            }
        }
        return output;
    }

    public void addDevice(Device device){
        deviceList.add(device);
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

    public CacyLinkedList<Device> getDeviceList() {
        return deviceList;
    }

    public static Patient create(){
        Patient patient = new Patient();

        patient.addDevice(new DivHeartRateMonitor());
        patient.addDevice(new DivOxygenSaturationMonitor());
        patient.addDevice(new DivRespirationMonitor());
        patient.addDevice(new DivTemperatureMonitor());
        patient.addDevice(new DivCallBell());

        return patient;
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
