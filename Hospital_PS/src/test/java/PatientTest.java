import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hospitalRecord.Patient;
import hospitalRecord.Visits;
import utilities.CustomTypes.HospitalLocation;

public class PatientTest {

	Patient patient;

	@BeforeClass
	public void setUp() {
		patient = new Patient("Patient 1",HospitalLocation.DELHI);
	}

	@Test
	public void validatePatientVisitAfterDate() {

		Visits visit1 = new Visits(LocalDate.of(2021, 01, 01));
		patient.addVisit(visit1);

		Visits visit2 = new Visits(LocalDate.of(2022, 01, 01));
		patient.addVisit(visit2);

		boolean isPatientVisitedAfterDate = patient.isPatientVistedAfter(LocalDate.of(2021,12,01));
		Assert.assertTrue(isPatientVisitedAfterDate);

		isPatientVisitedAfterDate = patient.isPatientVistedAfter(LocalDate.of(2023, 12, 01));
		Assert.assertFalse(isPatientVisitedAfterDate);

	}

	@Test
	public void validatePatientVisitBeforeDate() {

		Visits visit1 = new Visits(LocalDate.of(2021, 01, 01));
		patient.addVisit(visit1);

		Visits visit2 = new Visits(LocalDate.of(2019, 01, 01));
		patient.addVisit(visit2);

		boolean isPatientVistedBefore = patient.isPatientVistedBefore(LocalDate.of(2021,01,01));
		Assert.assertTrue(isPatientVistedBefore);

		isPatientVistedBefore = patient.isPatientVistedBefore(LocalDate.of(2010,12,01));
		Assert.assertFalse(isPatientVistedBefore);

	}

}
