import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {
    @BeforeEach
    void preTest(){
        Main.setupSimForTests();
    }

    @Test
    void addPatient() {
        Hospital hospital = Main.getSim().getHospital();
        assertEquals(0, hospital.patientCount(), "Empty hospital returned with non-zero patient count");
        hospital.addPatient(new Patient());
        assertEquals(1, hospital.patientCount(), "Hospital with one patients returned with count other then one");
    }

    @Test
    void addNurse(){
        Hospital hospital = Main.getSim().getHospital();
        assertEquals(0, hospital.waitingNurses(), "Hospital starting with nurses");
        hospital.addNurse(new Nurse(1));
        assertEquals(1, hospital.waitingNurses(), "Hospital not receiving stored nurse");
    }
}