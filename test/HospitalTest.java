import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {

    @Test
    void addPatient() {
        Hospital hospital = new Hospital();
        assertEquals(0, hospital.patientCount(), "Empty hospital returned with non-zero patient count");
        hospital.addPatient(new Patient());
        assertEquals(1, hospital.patientCount(), "Hospital with one patients returned with count other then one");
    }
}