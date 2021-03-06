import java.time.LocalDate;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hospitalRecord.Hospital;
import hospitalRecord.Patient;
import hospitalRecord.Visits;
import utilities.CustomTypes.HospitalLocation;

public class HospitalAppTest {

	Hospital hospital;

	@BeforeTest
	public void beforeClass() {
		hospital = new Hospital(HospitalLocation.BANGALORE);

		Patient patient = new Patient("Patient 1",HospitalLocation.DELHI);

		Visits visit1 = new Visits(LocalDate.of(2021, 01, 01));
		patient.addVisit(visit1);
		Visits visit2 = new Visits(LocalDate.of(2022, 01, 01));
		patient.addVisit(visit2);
		hospital.addPatient(patient);

		patient = new Patient("Patient 2",HospitalLocation.BANGALORE);
		visit1 = new Visits(LocalDate.of(2021, 01, 01));
		patient.addVisit(visit1);

		visit2 = new Visits(LocalDate.of(2022, 01, 01));
		patient.addVisit(visit2);
		hospital.addPatient(patient);

		patient = new Patient("Patient 3",HospitalLocation.BANGALORE);
		visit1 = new Visits(LocalDate.of(2021, 01, 01));
		patient.addVisit(visit1);
		hospital.addPatient(patient);

		patient = new Patient("Patient 4",HospitalLocation.DELHI);
		visit1 = new Visits(LocalDate.of(2021, 01, 01));
		patient.addVisit(visit1);
		hospital.addPatient(patient);
	}

	@Test
	public void getPatients() {
		List<Patient> allPatients = hospital.getPatients();
		Assert.assertTrue(allPatients.size() == 4);
	}

	@Test
	public void addPatient() {
		int initialPatientsCount = hospital.getPatients().size();

		Patient patient = new Patient("Patient 1",HospitalLocation.DELHI);
		Visits visit1 = new Visits(LocalDate.of(1990, 01, 01));
		patient.addVisit(visit1);

		hospital.addPatient(patient);

		Assert.assertTrue(hospital.getPatients().size() == initialPatientsCount + 1);
	}

	@Test
	public void validatePatientLocality() {
		Patient patient = new Patient("Patient 1",HospitalLocation.DELHI);
		boolean isPatientLocal = patient.isPatientLocal(hospital.getLocation());
		Assert.assertFalse(isPatientLocal);
		
		patient = new Patient("Patient 1",HospitalLocation.BANGALORE);
		isPatientLocal = patient.isPatientLocal(hospital.getLocation());
		Assert.assertTrue(isPatientLocal);
	}

	@Test
	public void validatePatientFilterWithDateRange() {

		long localPatientCount = hospital.getLocalPatientCountWithinDateRange(LocalDate.of(2020, 12, 01), LocalDate.of(2021, 02, 01));
		Assert.assertTrue((int) localPatientCount == 2);

	}

	@Test
	public void validateAllPatientsWithDateRange() {

		long localPatientCount = hospital.getAllPatientCountWithinDateRange(LocalDate.of(2020, 12, 01), LocalDate.of(2022, 02, 01));
		Assert.assertTrue((int) localPatientCount == 4);

	}

	@Test
	public void validateLocalPatiencePercentCountWithDataRange() {

		double patientPercentage = hospital.getLocalPatientsPercentage(LocalDate.of(2020, 12, 01), LocalDate.of(2022, 02, 01));
		Assert.assertTrue(patientPercentage == 50.0);

	}

}
