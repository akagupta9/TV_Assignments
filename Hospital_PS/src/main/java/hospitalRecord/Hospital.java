package hospitalRecord;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
	private List<Patient> patients;
	private String location = "Bangalore";

	public Hospital(String location) {
		this.location = location;
		patients = new ArrayList<>();
	}

	public String getLocation() {
		return location;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void addPatient(Patient patient) {
		patients.add(patient);
	}

	public long getLocalPatientCountWithinDateRange(LocalDate fromDate, LocalDate toDate) {

		return this.getPatients().stream().filter(patient -> (patient.isPatientLocal(getLocation())
				&& patient.isPatientVistedAfter(fromDate) && patient.isPatientVistedBefore(toDate))).count();

	}

	public long getAllPatientCountWithinDateRange(LocalDate fromDate, LocalDate toDate) {

		return this.getPatients().stream()
				.filter(patient -> patient.isPatientVistedAfter(fromDate) && patient.isPatientVistedBefore(toDate))
				.count();
	}

	public double getLocalPatientsPercentage(LocalDate fromDate, LocalDate toDate) {
		long allPatient = getAllPatientCountWithinDateRange(fromDate, toDate);

		if (allPatient == 0) {
			return 0.0;
		}
		long localPatient = getLocalPatientCountWithinDateRange(fromDate, toDate);
		double localPatientPercentage = ((localPatient) * 100) / allPatient;
		return localPatientPercentage;
	}

}
