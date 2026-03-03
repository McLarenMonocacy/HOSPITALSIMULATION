import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void getDateOfBirth() {
        Patient patient = new Patient();
        patient.setDateOfBirth(new Date(795157200));
        assertEquals(0, patient.getDateOfBirth().compareTo(new Date(795157200)), "The get or set function didn't work properly");
    }

    @Test
    void getNameSimple() {
        Patient patient = new Patient();
        patient.setName("some name here");
        assertEquals("some name here", patient.getName(), "The get or set function didn't work properly");
    }

    @Test
    void getNameWithUppers() {
        Patient patient = new Patient();
        patient.setName("SOME name HERE");
        assertEquals("some name here", patient.getName(), "The name was not stored in all lowercase");
    }

    @Test
    void getUuid() {
        Patient patient = new Patient();
        Patient patient1 = new Patient();
        assertNotSame(patient.getUuid(), patient1.getUuid());
    }
}