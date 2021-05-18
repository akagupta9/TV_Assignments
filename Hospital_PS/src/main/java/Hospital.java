import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Patient> patients;

    Hospital() {
        patients = new ArrayList<>();
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void addPatient(String name, String visitLocation, String visitDate) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setVisitDate(visitDate);
        patient.setVisitLocation(visitLocation);
        patients.add(patient);
    }

    public long getLocalPatientCountWithinDateRange(String fromDate, String toDate) {

        return this.getPatients()
                .stream()
                .filter(patient -> (patient.isPatientLocal()
                        && patient.isPatientVistedAfter(fromDate)
                        && patient.isPatientVistedBefore(toDate)))
                .count();

    }

    public long getAllPatientCountWithinDateRange(String fromDate, String toDate) {

        return this.getPatients()
                .stream()
                .filter(patient -> patient.isPatientVistedAfter(fromDate)
                        && patient.isPatientVistedBefore(toDate))
                .count();
    }

    public String getPatientsDetailsWithinDateRange(String fromDate, String toDate) {
        long allPatient = getAllPatientCountWithinDateRange(fromDate, toDate);

        if (allPatient == 0) {
            return String.format("\n Local Patient Count: 0, \n Total Patient Count: 0, \n Local Patient Percentage: 0");
        }
        long localPatient = getLocalPatientCountWithinDateRange(fromDate, toDate);
        double localPatientPercentage = ((localPatient)*100) / allPatient;
        return String.format("\n Local Patient Count: %s, \n Total Patient Count: %s, \n Local Patient Percentage: %s", localPatient, allPatient, localPatientPercentage);
    }

}
