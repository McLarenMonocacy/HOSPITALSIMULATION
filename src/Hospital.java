public class Hospital {

    private final CacyLinkedList<Patient> patientList;
    //List of nurses will need to be added later
    //I would put this in an array but java doesn't seam to like that
    private final CacyQueue<Alert> alertQueuePriority1;
    private final CacyQueue<Alert> alertQueuePriority2;
    private final CacyQueue<Alert> alertQueuePriority3;
    private final CacyQueue<Alert> alertQueuePriority4;
    private final CacyQueue<Alert> alertQueuePriority5;

    public Hospital(){
        patientList = new CacyLinkedList<>();
        //This will need to be updated with the new separate queue class
        alertQueuePriority1 = new CacyLinkedList<>();
        alertQueuePriority2 = new CacyLinkedList<>();
        alertQueuePriority3 = new CacyLinkedList<>();
        alertQueuePriority4 = new CacyLinkedList<>();
        alertQueuePriority5 = new CacyLinkedList<>();
    }

    public Hospital(){
        patientList = new CacyLinkedList<>();
    }

    public void addPatient(Patient patient){
        patientList.add(patient);
    }

    public void pollDevices(){
        //Calls pollDevices() on every patient
        patientList.initIterator();
        while (patientList.hasNext()){
            CacyQueue<Alert> receivedAlerts = patientList.next().pollDevices();
            while (receivedAlerts.peek() != null){
                Alert alert = receivedAlerts.poll();
                switch (alert.getPriority()){
                    case 1: alertQueuePriority1.offer(alert); break;
                    case 2: alertQueuePriority2.offer(alert); break;
                    case 3: alertQueuePriority3.offer(alert); break;
                    case 4: alertQueuePriority4.offer(alert); break;
                    case 5: alertQueuePriority5.offer(alert); break;
                }
            }

        }
    }

    public int patientCount(){
        return patientList.length();
    }
}
