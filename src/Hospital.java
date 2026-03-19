public class Hospital {

    CacyLinkedList<Patient> patientList;
    //List of nurses will need to be added later

    public void addPatient(Patient patient){
        patientList.add(patient);
    }

    public int patientCount(){
        return patientList.length();
    }
}
