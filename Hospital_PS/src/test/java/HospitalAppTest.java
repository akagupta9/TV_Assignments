import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HospitalAppTest {

	Hospital hospital;

	@BeforeTest
	public void beforeClass() {
		hospital = new Hospital();
		hospital.setLocation("Bangalore");

		Patient patient = new Patient();

		patient.setName("Patient 1");
		patient.setVisitDate("2021-01-01");
		patient.setVisitLocation("Bangalore");

		hospital.addPatient(patient);

		patient = new Patient();
		patient.setName("Patient 2");
		patient.setVisitDate("2021-02-01");
		patient.setVisitLocation("Delhi");

		hospital.addPatient(patient);

		patient = new Patient();
		patient.setName("Patient 3");
		patient.setVisitDate("2021-03-01");
		patient.setVisitLocation("Bangalore");

		hospital.addPatient(patient);

		patient = new Patient();
		patient.setName("Patient 4");
		patient.setVisitDate("2021-03-01");
		patient.setVisitLocation("Delhi");

		hospital.addPatient(patient);
	}

	@Test
	public void getPatients() {
		List<Patient> allPatients = hospital.getPatients();
		Assert.assertTrue(allPatients.size() >= 0);
	}

	@Test
	public void addPatient() {
		int initialPatientsCount = hospital.getPatients().size();

		Patient patient = new Patient();
		patient.setName("Patient 1");
		patient.setVisitDate("1999-01-10");
		patient.setVisitLocation("Bangalore");

		hospital.addPatient(patient);

		Assert.assertTrue(hospital.getPatients().size() == initialPatientsCount + 1);
	}

	@Test
	public void validatePatientLocality() {
		Patient patient = new Patient();
		patient.setVisitLocation("Delhi");
		boolean isPatientLocal = patient.isPatientLocal(hospital.getLocation());
		Assert.assertFalse(isPatientLocal);

		patient.setVisitLocation("Bangalore");
		isPatientLocal = patient.isPatientLocal(hospital.getLocation());
		Assert.assertTrue(isPatientLocal);
	}

	@Test
	public void validatePatientFilterWithDateRange() {

		long localPatientCount = hospital.getLocalPatientCountWithinDateRange("2020-12-01", "2021-02-01");
		Assert.assertTrue((int) localPatientCount == 1);

	}

	@Test
	public void validateAllPatientsWithDateRange() {

		long localPatientCount = hospital.getAllPatientCountWithinDateRange("2020-12-01", "2022-02-01");
		Assert.assertTrue((int) localPatientCount == 4);

	}

	@Test
	public void validateLocalPatiencePercentCountWithDataRange() {

		double patientPercentage = hospital.getLocalPatientsPercentage("2020-12-01", "2022-02-01");
		Assert.assertTrue(patientPercentage == 50.0);

	}

}
