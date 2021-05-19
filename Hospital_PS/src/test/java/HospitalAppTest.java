import java.time.LocalDate;
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
		patient.setVisitLocation("Delhi");
		Visits visit1 = new Visits();
		visit1.setDate(LocalDate.parse("2021-01-01"));
		patient.addVisit(visit1);
		Visits visit2 = new Visits();
		visit2.setDate(LocalDate.parse("2022-01-01"));
		patient.addVisit(visit2);
		hospital.addPatient(patient);

		patient = new Patient();
		patient.setName("Patient 2");
		patient.setVisitLocation("Bangalore");
		visit1 = new Visits();
		visit1.setDate(LocalDate.parse("2021-01-01"));
		patient.addVisit(visit1);

		visit2 = new Visits();
		visit2.setDate(LocalDate.parse("2022-01-01"));
		patient.addVisit(visit2);
		hospital.addPatient(patient);

		patient = new Patient();
		patient.setName("Patient 3");
		patient.setVisitLocation("Bangalore");
		visit1 = new Visits();
		visit1.setDate(LocalDate.parse("2021-01-01"));
		patient.addVisit(visit1);
		hospital.addPatient(patient);

		patient = new Patient();
		patient.setName("Patient 4");
		patient.setVisitLocation("Delhi");
		visit1 = new Visits();
		visit1.setDate(LocalDate.parse("2021-01-01"));
		patient.addVisit(visit1);
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
		patient.setVisitLocation("Delhi");
		Visits visit1 = new Visits();
		visit1.setDate(LocalDate.parse("1990-01-01"));
		patient.addVisit(visit1);

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
		Assert.assertTrue((int) localPatientCount == 2);

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
