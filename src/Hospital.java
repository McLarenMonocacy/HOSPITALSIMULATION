public class Hospital {
    private class LinkedPatient{
        Patient heldPatient;
        LinkedPatient nextLink = null;

        LinkedPatient(Patient patient){
            this.heldPatient = patient;
        }

        void add(Patient patient){
            if (nextLink == null) nextLink = new LinkedPatient(patient);
            else nextLink.add(patient);
        }
    }

    LinkedPatient patientList;

    public void addPatient(Patient patient){
        if (patient == null) return;
        if (patientList == null) patientList = new LinkedPatient(patient);
        else patientList.add(patient);
    }
}
