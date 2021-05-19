import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Patient> patients;
    private String location = "Bangalore";
    
    Hospital() {
        patients = new ArrayList<>();
    }

    public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

    public List<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public long getLocalPatientCountWithinDateRange(String fromDate, String toDate) {

        return this.getPatients()
                .stream()
                .filter(patient -> (patient.isPatientLocal(getLocation())
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

    public double getLocalPatientsPercentage(String fromDate, String toDate) {
        long allPatient = getAllPatientCountWithinDateRange(fromDate, toDate);

        if (allPatient == 0) {
            return 0.0;
        }
        long localPatient = getLocalPatientCountWithinDateRange(fromDate, toDate);
        double localPatientPercentage = ((localPatient)*100) / allPatient;
        return localPatientPercentage;
    }

}
