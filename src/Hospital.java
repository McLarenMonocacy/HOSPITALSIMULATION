public class Hospital {

    private final CacyLinkedList<Patient> patientList;
    private final CacyQueue<Nurse> waitingNurses;
    //I would put this in an array but java doesn't seam to like that
    private final CacyQueue<Alert> alertQueuePriority1;
    private final CacyQueue<Alert> alertQueuePriority2;
    private final CacyQueue<Alert> alertQueuePriority3;
    private final CacyQueue<Alert> alertQueuePriority4;
    private final CacyQueue<Alert> alertQueuePriority5;

    private final CacyLinkedList<Alert> alertsInProgress;

    public Hospital(){
        patientList = new CacyLinkedList<>();
        waitingNurses = new CacyQueue<>();
        alertQueuePriority1 = new CacyQueue<>();
        alertQueuePriority2 = new CacyQueue<>();
        alertQueuePriority3 = new CacyQueue<>();
        alertQueuePriority4 = new CacyQueue<>();
        alertQueuePriority5 = new CacyQueue<>();
        alertsInProgress = new CacyLinkedList<>();
    }

    public void addPatient(Patient patient){
        if (patient == null) return;
        patientList.add(patient);
    }

    public void addNurse(Nurse nurse){
        if (nurse == null) return;
        waitingNurses.queue(nurse);
    }

    public void pollDevices(){
        //Calls pollDevices() on every patient
        patientList.initIterator();
        while (patientList.hasNext()){
            CacyQueue<Alert> receivedAlerts = patientList.next().pollDevices();
            while (receivedAlerts.peek() != null){
                Alert alert = receivedAlerts.dequeue();
                switch (alert.getPriority()){
                    case 1: alertQueuePriority1.queue(alert); break;
                    case 2: alertQueuePriority2.queue(alert); break;
                    case 3: alertQueuePriority3.queue(alert); break;
                    case 4: alertQueuePriority4.queue(alert); break;
                    case 5: alertQueuePriority5.queue(alert); break;
                }
            }

        }
    }

    public void runNurses(){
        while (waitingNurses.length() > 0){
            Alert alert = getNextAlert();
            if (alert == null) break; //There are no alerts to be worked on
            alert.assignNurse(waitingNurses.dequeue());
            alertsInProgress.add(alert);
        }
        CacyQueue<Alert> alertsMarkedResolved = new CacyQueue<>();
        alertsInProgress.initIterator();
        while (alertsInProgress.hasNext()){
            Alert alert = alertsInProgress.next();
            if (alert.attemptResolve()){
                alertsMarkedResolved.queue(alert);
            }
        }
        while (alertsMarkedResolved.length() > 0){ //remove any resolved alerts
            Main.getSim().addResolvedAlert(alertsInProgress.remove(alertsMarkedResolved.dequeue()));
        }
    }

    private Alert getNextAlert(){
        //returns the next alert of highest priority
        if (alertQueuePriority5.length() > 0) return alertQueuePriority5.dequeue();
        if (alertQueuePriority4.length() > 0) return alertQueuePriority4.dequeue();
        if (alertQueuePriority3.length() > 0) return alertQueuePriority3.dequeue();
        if (alertQueuePriority2.length() > 0) return alertQueuePriority2.dequeue();
        if (alertQueuePriority1.length() > 0) return alertQueuePriority1.dequeue();
        return null;
    }

    public int patientCount(){
        return patientList.length();
    }

    public int waitingNurses(){
        return waitingNurses.length();
    }
}
