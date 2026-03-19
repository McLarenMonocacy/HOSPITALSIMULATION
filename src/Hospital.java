public class Hospital {

    CacyLinkedList<Patient> patientList;

    public void addPatient(Patient patient){
        patientList.add(patient);
    }

    public int patientCount(){
        return patientList.length();
    }
}
